import pyotp
import secrets
import base64
import json
import cherrypy
from utils import *
import sqlite3 as sql
import random
import string
from cryptography.fernet import Fernet
import os

# Function to load or generate the encryption key
def load_or_generate_key():
    key_file_path = "encryption_key.key"

    if os.path.exists(key_file_path):
        with open(key_file_path, "rb") as key_file:
            return key_file.read()
    else:
        # Generate a new key if the file doesn't exist
        key = Fernet.generate_key()
        with open(key_file_path, "wb") as key_file:
            key_file.write(key)
        return key

class TOTP(object):
    def __init__(self):
        # Load or generate the encryption key
        self.encryption_key = load_or_generate_key()
        self.cipher_suite = Fernet(self.encryption_key)

    def encrypt(self, plaintext):
        return self.cipher_suite.encrypt(plaintext.encode('utf-8'))

    def decrypt(self, ciphertext):
        return self.cipher_suite.decrypt(ciphertext).decode('utf-8')

    def login(self, nome, password, totp_key):
        db = sql.connect("database.db")
        password_plain = password

        # encrypt password with sha256, so that it can be compared with the encrypted password in the database
        password = hashlib.sha256(password.encode()).hexdigest()

        user = db.execute("SELECT * FROM Users WHERE user = ? AND password = ?", (nome, password)).fetchall()
        if len(user) == 0:
            # password does not match
            db.close()
            return (False, "Username ou palavra-passe errados.")

        if check_breached_password(password_plain):
            # password is breached, inform the user and force them to change their password
            return (False, "A palavra-passe foi encontrada numa violação de dados.\n Por favor, altere-a.")

        totp=db.execute("SELECT key FROM TOTP WHERE username = ?", (nome,)).fetchone()
        if totp == None:
            db.close()
            return (False, "Por favor insira a sua key de TOTP.")

        totp=pyotp.TOTP(self.decrypt(totp[0]))
        db.close()

        if totp.verify(totp_key):
            return (True,)
        else:
            return (False, "Código TOTP errado.")

    @cherrypy.expose
    def generate_totp(self, username):
        db=sql.connect("database.db")
        # Generate a random base32-encoded key
        random_key_bytes = secrets.token_bytes(20)  # 20 bytes for a 160-bit key
        random_key_base32 = base64.b32encode(random_key_bytes).decode('ascii')
        encrypted_key = self.encrypt(random_key_base32)
        
        db.execute("INSERT INTO TOTP(username,key) VALUES(?, ?)", (username, encrypted_key))
        db.commit()
        db.close()

        cherrypy.response.headers["Content-Type"] = "application/json"
        return json.dumps({"totp": random_key_base32}).encode("utf8")
    
    @cherrypy.expose
    def auth(self, username=None, password=None, totp_key=None, **params ):
        result = {"authentication": "INVALID", "token": "", "reason": ""}
        res = self.login(username, password, totp_key)

        if res[0]:
            # all good
            result["authentication"] = "OK"
            result["token"] = ''.join(random.choice(string.ascii_uppercase + string.digits + string.ascii_lowercase) for _ in range(10))
            setToken(username, result["token"])
            return json.dumps(result)
        else:
            # some problem
            result["reason"] = res[1]

        return json.dumps(result)
