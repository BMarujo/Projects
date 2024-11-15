import json
import cherrypy
from utils import *
import sqlite3 as sql
import hashlib

class Profile(object):
    @cherrypy.expose
    def default(self, *url_parts, **params):
        return open("html/profile.html")

    @cherrypy.expose
    def show_avatar(self,token, **params):
        if type(token)==list:
            token=token[0]
        token = decryptData(token)  # decryptToken
        if token == None:
            raise cherrypy.HTTPRedirect("/collections", status=301)
        

        db = sql.connect("database.db")
        avatar = db.execute("SELECT avatar FROM Users WHERE token=?;", (token,)).fetchall()
        if avatar[0][0] == None or avatar[0][0] == "":
            username = db.execute("SELECT user FROM Users WHERE token=?;", (token,)).fetchall()
            username = username[0][0] # username = [(username,)]

            defaultAvatarPath = "./img/html/logoDeti.png"
            newAvatarPath = './img/avatars/' + username + '.png'

            with open(defaultAvatarPath, 'rb') as source_file, open(newAvatarPath, 'wb') as dest_file:
                while True:
                    data = source_file.read(8192)
                    if not data:
                        break
                    dest_file.write(data)

            db.execute("UPDATE USERS SET avatar = ? WHERE token = ?;", ('../img/avatars/' + username + '.png', token))
            db.commit()
            return json.dumps("../img/html/logoDeti.png")

        db.close()
        return json.dumps(avatar[0][0])

    @cherrypy.expose
    def upload_avatar(self, newAvatar=None, **params):
        # check if a token is present
        result = {"DONE": "NO", "ERROR": ""}
        token = cherrypy.request.cookie.get('token')
        if token == None:
            result["ERROR"] = "Token inválido."
            return json.dumps(result)
        elif type(token)==list:
            token=token[0]

        # get the actual token string
        token = token.value

        # check is an Avatar is present
        if newAvatar == "":
            result["ERROR"] = "Por favor selecione uma imagem."
            return json.dumps(result)

        # check the file size
        max_size_in_bytes = 5 * 1024 * 1024  # 5 MB
        content_length = 0
        while True:
            data = newAvatar.file.read(8192)
            if not data:
                break
            content_length += len(data)

            if content_length > max_size_in_bytes:
                result["ERROR"] = "O ficheiro selecionado excede o tamanho máximo (5 MB). Por favor escolha outra imagem."
                return json.dumps(result)

        db = sql.connect("database.db")
        username = db.execute("SELECT user FROM Users WHERE token=?;", (token,)).fetchall()

        # save the image file
        with open('./img/avatars/' + username[0][0] + '.png', 'wb') as f:
            # reset file pointer to the beginning of the file
            newAvatar.file.seek(0)
            while True:
                data = newAvatar.file.read(8192)
                if not data:
                    break
                f.write(data)

        result["DONE"] = "YES"
        return json.dumps(result)

    @cherrypy.expose
    def show_username(self, token=None, **params):
        if type(token)==list:
            token=token[0]
        token = decryptData(token)  # decryptToken
        if token == None:
            raise cherrypy.HTTPRedirect("/collections", status=301)

        db = sql.connect("database.db")
        username = db.execute("SELECT name FROM Users WHERE token=?;", (token,)).fetchall()
        if username[0][0] == None:
            username = db.execute("SELECT user FROM Users WHERE token=?;", (token,)).fetchall()

        db.close()
        return json.dumps(username[0][0])

    @cherrypy.expose
    def change_username(self, token=None, newUsername="", **params):   # by adding "**params" to the function parameters, we can handle the extra parameters that attackers might add 
        if type(token)==list:
            token=token[0]
        token = decryptData(token)  # decryptToken
        if token == None:
            raise cherrypy.HTTPRedirect("/collections", status=301)
        
        if newUsername == "":
            return json.dumps("Por favor insira um username.")
        elif type(newUsername)==list:   # if the attacker tries to use "HTTP parameter pollution" 
            newUsername=newUsername[0]  # we will utilize the first "newUsername" provided in the URL

        db = sql.connect("database.db")
        db.execute("UPDATE Users SET name = ? WHERE token = ?;", (newUsername, token))
        db.commit()
        db.close()
        return json.dumps("Username alterado com sucesso.")

    @cherrypy.expose
    def change_password(self, password="", newPassword="", token=None,**params): # by adding "**params" to the function parameters, we can handle the extra parameters that attackers might add
        # we need at least the token or the username to be valid
        if type(token)==list:
            token=token[0]
        token = decryptData(token)  # decryptToken
        if token == None:
            raise cherrypy.HTTPRedirect("/collections", status=301)

        result = {"DONE": "NO", "ERROR": ""}

        # check password
        if type(password)==list:  # if the attacker tries to use "HTTP parameter pollution" 
            password=password[0]    # we will utilize the first "password" provided in the URL
        print("PASSWORD CIPHERED ------------------------> ",password)
        password = decryptData(password)    # decrypt password
        print("PASSWORD DECIPHERED ------------------------> ",password)
        if password == "" or password == None:
            result["ERROR"] = "Insira a sua palavra-passe."
            return json.dumps(result)   
        

        # check new password
        if newPassword == "" or newPassword==None:
            result["ERROR"] = "Insira a nova palavra-passe."
            return json.dumps(result)
        elif type(newPassword)==list:   # if the attacker tries to use "HTTP parameter pollution" 
            newPassword=newPassword[0]  # we will utilize the first "newPassword" provided in the URL
        newPassword = decryptData(newPassword)


        # check if new password meets the requirements
        res = check_password_requirements(newPassword)
        if res[0] == False:
            result["ERROR"] = res[1]
            return json.dumps(result)

        # check if new password was breached before
        if check_breached_password(newPassword):
            result["ERROR"] = "A sua nova palavra-passe foi encontrada numa violação de dados. Por favor mude-a."
            return json.dumps(result)

        db = sql.connect("database.db")
        newPassword = hashlib.sha256(newPassword.encode()).hexdigest()

        # check password by username or by token
        current_password = db.execute("SELECT password FROM Users WHERE token=?;", (token,)).fetchall()
        if len(current_password) == 0:
            result["ERROR"] = "Token inválido."
            return json.dumps(result)

        password = hashlib.sha256(password.encode()).hexdigest()
        if password != current_password[0][0]:
            db.close()
            result["ERROR"] = "Palavra-passe está mal."
            return json.dumps(result)

        # update password
        db.execute("UPDATE Users SET password=? WHERE token=?;", (newPassword, token))

        db.commit()
        db.close()
        result["DONE"] = "YES"
        return json.dumps(result)

    @cherrypy.expose
    def deleteAccount(self, token=None, **params):
        if type(token)==list:
            token=token[0]
        token = decryptData(token)  # decryptToken
        if (validToken(token)):
            # Apagar a conta, ou seja, apagar todos os dados do utilizador na DB (incluindo os seus produtos no carrinho e produtos comprados(OrderHistory))
            # Apagar dados na OrderHistory, depois os do UserProducts e por fim a sua conta no Users (isto tudo atraves do userID)
            db = sql.connect("database.db")
            cursor = db.cursor()
            userID = cursor.execute("SELECT Id FROM Users WHERE token = ?;", (token,)).fetchall()[0][0]
            username = cursor.execute("SELECT user FROM Users WHERE token=?;", (token,)).fetchall()[0][0]

            cursor.execute("DELETE FROM OrderHistory WHERE IdUsr = ?;", (str(userID),))

            # Antes de apagar os UserProducts temos de voltar a adicionar os produtos ao stock
            result = getUserProducts(token)

            for product in result:  # [product_name, path, quantity, price,id,productQuantity]
                old_quantity = product[2]
                product_id = product[4]
                productQuantity = product[5]
                cursor.execute("UPDATE Products SET quantity = ? WHERE Id = ?;", (productQuantity+old_quantity,product_id))

            cursor.execute("DELETE FROM UserProducts WHERE UserId = ?;", (str(userID),))
            cursor.execute("DELETE FROM Users WHERE Id = ?;", (str(userID),))
            cursor.execute("DELETE FROM TOTP WHERE username = ?;", (str(username),))

            db.commit()
            db.close()
            deleteToken(token)

            return json.dumps({"deleted": "YES"})
        else:
            return json.dumps({"deleted": "NO"})
