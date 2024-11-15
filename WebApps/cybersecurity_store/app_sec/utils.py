import binascii
import sqlite3 as sql
import hashlib
import requests
import re
import cherrypy
from Crypto.Cipher import AES
from Crypto.Util.Padding import unpad
import binascii
import base64

def combine_spaces(input_string):
    output_string = re.sub(r'\s+', ' ', input_string)
    return output_string

def check_password_requirements(password):
    special_chars =  ["$", "&", "!"]
    if len(password) < 12 or len(password) > 128:
        return(False, "ATENÇÂO: Espaços consecutivos serão considerados como um só.")
    elif not any(char.isdigit() for char in password) :
        return(False, "")
    elif not any(char.isupper() for char in password):
        return(False, "")
    elif not any(char.islower() for char in password):
        return(False, "")
    elif not any(char in special_chars for char in password):
        return(False, "")
    else: 
        return (True, "")

def check_breached_password(password):
    # hash the password with SHA-1
    sha1_password = hashlib.sha1(password.encode()).hexdigest()

    # send request to 'have i been pwned' to receive matching hashes
    similar_passwords = requests.get(f"https://api.pwnedpasswords.com/range/{sha1_password[:5]}")

    if similar_passwords.status_code == 200:
        # parse the response and find out if the password was breached
        for p in similar_passwords.text.split("\n"):
            # get just the password hash
            passwd = p.split(":")[0]

            # check if password hashes match
            if sha1_password.endswith(passwd.lower()):
                # True means that the password was breached
                return True

    return False

def signin(nome, password):
    password = combine_spaces(password)

    # check if password was breached before
    if check_breached_password(password):
        return (False, "A palavra-passe foi encontrada numa violação de dados.\n Por favor, altere-a.")

    res = check_password_requirements(password)
    if res[0]:
        db = sql.connect("database.db")
        user = db.execute("SELECT * FROM Users WHERE user = ?", (nome,)).fetchall()
        if len(user) != 0:
            db.close()
            return (False, "Username já em uso.")

        # encrypt password with sha256, using the hashlib library, so that the password is not stored in plain text
        password = hashlib.sha256(password.encode()).hexdigest()

        cursor = db.cursor()
        cursor.execute("INSERT INTO Users(user,password) VALUES(?, ?)", (nome, password))
        db.commit()
        db.close()
        return (True, "")
    else:
        return res

def setToken(nome, token):
    db = sql.connect("database.db")
    cursor = db.cursor()
    cursor.execute("UPDATE Users SET token = ? WHERE user = ?;", (token, nome))
    db.commit()
    db.close()

def validToken(token):
    db = sql.connect("database.db")
    
    user = db.execute("SELECT * FROM Users WHERE token = ?", (token,)).fetchall()
    if len(user) == 0:
        db.close()
        return False
    db.close()
    return True

def deleteToken(token):
    if validToken(token):
        db = sql.connect("database.db")
        cursor = db.cursor()
        cursor.execute("UPDATE Users SET token = '' WHERE token = ?", (token,))
        db.commit()
        db.close()
        return True
    else:
        return False

def getUserProducts(token, update=0): # o update vai ser o id do produto que foi adicionado
    result = []
    if not validToken(token):
        return result

    db = sql.connect("database.db")
    userId = db.execute("SELECT Id FROM Users WHERE token = ?", (token,)).fetchall()[0][0]
    products = db.execute("SELECT Products.* FROM Products JOIN UserProducts ON Products.Id = UserProducts.ProductId WHERE UserProducts.UserId = ?", (userId,)).fetchall()
    if update != 0:
        old_quantity = db.execute("SELECT Quantity FROM UserProducts WHERE ProductId = ?", (update,)).fetchall()[0][0]
        db.execute("UPDATE UserProducts SET Quantity = ? WHERE UserId = ?", (old_quantity+1,userId))
        db.commit()
    else:
        if len(products) == 0:
            db.close()
            return result
        else:
            for product in products: # product = [id, path, comment,quantity, name, price]
                id = product[0]
                path = product[1]
                quantity = db.execute("SELECT Quantity FROM UserProducts WHERE ProductId = ? AND userID=?", (id,userId)).fetchall()[0][0]
                productQuantity = db.execute("SELECT quantity FROM Products WHERE Id = {};".format(id)).fetchall()[0][0]
                product_name = product[-2]
                price = product[-1]
                result.append([product_name, path, quantity, price,id,productQuantity])          
    db.close()
    return result

def removeUserProduct(token,productId):
    if not validToken(token):
        return 

    if productId == None:
        return
    db = sql.connect("database.db")
    userId = db.execute("SELECT Id FROM Users WHERE token = ?", (token,)).fetchall()[0][0]
    quantity = db.execute("SELECT Quantity FROM UserProducts WHERE ProductId = ? AND USERID = ?", (productId,userId)).fetchall()
    if quantity!=[]:
        quantity=quantity[0][0]
    else:
        return
    db.execute("UPDATE Products SET quantity = quantity + ? WHERE Id = ?", (quantity, productId))
    db.execute("DELETE FROM UserProducts WHERE UserId = ? AND ProductId = ?", (userId, productId))
    db.commit()
    db.close()

def removeAllUserProducts(token):
    if not validToken(token):
        return 

    db = sql.connect("database.db")
    userId = db.execute("SELECT Id FROM Users WHERE token = ?", (token,)).fetchall()[0][0]
    db.execute("DELETE FROM UserProducts WHERE UserId = ?", (userId,))
    # print to see if it was deleted
    #print("DELETE FROM UserProducts WHERE UserId = {}".format(userId))
    for product in db.execute("SELECT * FROM UserProducts WHERE UserId = ?", (userId,)).fetchall():
        print("it was not deleted")
        print(product)
    db.commit()    
    db.close()

# FUNÇÃO FEITA PARA A PÁGINA DO CARRINHO ONDE SE ESTÁ A AUMENTAR OU DIMINUIR A QUANTIDADE DO PRODUTO
def updateUserQuantity(token, productId, newQuantity): # addToQuantity should be equal to 1 or -1
    if not validToken(token):
        print("invalid token ON removeUserProduct")
        return 

    if productId == None:
        print("productId is None")
        return
    if type(productId)==list:
        productId=productId[0]
    if type(newQuantity)==list:
        newQuantity=newQuantity[0]
    if type(newQuantity)!=int:
        return "Inválido"

    db = sql.connect("database.db")
    userId = db.execute("SELECT Id FROM Users WHERE token = ?", (token,)).fetchall()[0][0]
    oldQuantity = db.execute("SELECT Quantity FROM UserProducts WHERE ProductId = ?", (productId,)).fetchone()
    if oldQuantity!=None:
        oldQuantity=oldQuantity[0]
    else:
        return "Inválido"
    quantityToAdd = oldQuantity - int(newQuantity) 
    oldProductQuantity = db.execute("SELECT quantity FROM Products WHERE Id = ?", (productId,)).fetchone()[0]
    newProductQuantity = oldProductQuantity + quantityToAdd
    if newProductQuantity >= 0:
        db.execute("UPDATE Products SET quantity = ? WHERE Id = ?", (newProductQuantity,productId))    
        db.execute("UPDATE UserProducts SET Quantity = ? WHERE UserId = ? AND ProductId = ?", (newQuantity,userId,productId))
        db.commit()
        db.close()
        return "Quantidade Atualizada"
    else:
        db.close()
        return "Quantidade Inválida"

def getUsernameFromToken(token, db=None):
    if db == None:
        db = sql.connect("database.db")

    user_name = db.execute("SELECT user FROM Users WHERE token = ?", (token,)).fetchall()
    if db == None:
        db.close()

    return user_name[0][0]

def getUserIdFromToken(token, db=None):
    if db == None:
        db = sql.connect("database.db")

    user_name = db.execute("SELECT Id FROM Users WHERE token = ?", (token,)).fetchall()
    if db == None:
        db.close()
    return user_name[0][0]

def decryptData(data):
    data=data.replace(" ", "+")
    #print("DATA ------------------------->",data,len(data))
    if len(data)!= 24:
        return None
    secret_key = binascii.unhexlify('2b7e151628aed2a6abf7158809cf4f3c')

    # Decryption using provided key
    cipher = AES.new(secret_key, AES.MODE_ECB)  # Use the appropriate mode (e.g., CBC, GCM)

    encrypted_data = base64.b64decode(data)
    decrypted_data = unpad(cipher.decrypt(encrypted_data), AES.block_size).decode('utf-8')

    # Now `decrypted_data` holds the new data in plain text
    # Use it as needed (e.g., update in the database)

    # Return a success response to the client
    return decrypted_data


def verify_pass(password, token):
    db = sql.connect("database.db")
    token = decryptData(token)  # decryptToken
    current_password = db.execute("SELECT password FROM Users WHERE token=?;", (token,)).fetchall()
    if len(current_password) == 0:
        return False
    password = hashlib.sha256(password.encode()).hexdigest()
    if password != current_password[0][0]:
        db.close()
        return False
    return True
        

