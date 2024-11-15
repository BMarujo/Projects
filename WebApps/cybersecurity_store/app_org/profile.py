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
    def show_avatar(self,token):
        if token == None:
            print("----------IM HEREEE BUT THE TOKEN IS INVALID------")
            raise cherrypy.HTTPRedirect("/collections", status=301)
        db=sql.connect("database.db")
        print("----------SHOW AVATAR------")
        #avatar = db.execute("SELECT avatar FROM Users WHERE token ='{}';".format(token)).fetchall()
        avatar = db.execute("SELECT avatar FROM Users WHERE token =?;",(token,)).fetchall()
        # avatar = [(None,)]
        print("avatar_before: ",avatar[0][0])
        if avatar[0][0] == None or avatar[0][0] == "":
            #username = db.execute("SELECT user FROM Users WHERE token ='{}';".format(token)).fetchall()
            username = db.execute("SELECT user FROM Users WHERE token =?;",(token,)).fetchall()
            username = username[0][0]   # username = [(username,)]
            print("username in avatar: ",username)
            
            defaultAvatarPath = "./img/html/logoDeti.png"
            newAvatarPath = './img/avatars/' + username + '.png'

            with open(defaultAvatarPath, 'rb') as source_file, open(newAvatarPath, 'wb') as dest_file:
                while True:
                    data = source_file.read(8192)
                    if not data:
                        break
                    dest_file.write(data)
            #db.execute("UPDATE USERS SET avatar = '{}' WHERE token = '{}';".format('../img/avatars/'+username+'.png',token))
            db.execute("UPDATE USERS SET avatar = ? WHERE token = ?;",('../img/avatars/'+username+'.png',token))
            db.commit()
            #print(sorted(files,key=None,reverse=True))

            return json.dumps("../img/html/logoDeti.png")
        print("avatar: ",avatar[0][0])
        db.close()
        return json.dumps(avatar[0][0])

    @cherrypy.expose
    def change_avatar(self,token,newAvatar):    # FALTA FAZER COM QUE O SERVIDOR RECEBA A IMAGEM
        if token == None:
            raise cherrypy.HTTPRedirect("/collections", status=301)
        if newAvatar == "":
            return json.dumps("no Image")
        print("---------CHANGING AVATAR-------------")

        db=sql.connect("database.db")
        #db.execute("UPDATE USERS SET avatar = '{}' WHERE token = '{}';".format(newAvatar,token))    
        db.execute("UPDATE USERS SET avatar = ? WHERE token = ?;",(newAvatar,token))
        db.commit()
        #print("newAvatar: ",db.execute("SELECT avatar FROM Users WHERE token ='{}';".format(token)).fetchall())
        print("newAvatar: ",db.execute("SELECT avatar FROM Users WHERE token =?;",(token,)).fetchall())
        db.close()
        return json.dumps("changed avatar")

    @cherrypy.expose
    def upload_avatar(self, newAvatar):
        # Here 'avatar' is the uploaded file
        # Save the uploaded file to a location on your server
        print("---------UPLOADING AVATAR-------------")
        db=sql.connect("database.db")
        token = cherrypy.request.cookie.get('token').value
        #username = db.execute("SELECT user FROM Users WHERE token ='{}';".format(token)).fetchall()
        username = db.execute("SELECT user FROM Users WHERE token =?;",(token,)).fetchall()
        print("username: ",username)
        if newAvatar == "":
            return json.dumps("no Image")
        with open('./img/avatars/'+username[0][0]+'.png', 'wb') as f:
            while True:
                data = newAvatar.file.read(8192)
                if not data:
                    break
                f.write(data)
        result = {'success': 'uploaded avatar','newAvatarPath': '../img/avatars/'+username[0][0]+'.png'}
        return json.dumps(result)

    @cherrypy.expose
    def show_username(self,token):
        if token == None:
            print("----------IM HEREEE BUT THE TOKEN IS INVALID------")
            raise cherrypy.HTTPRedirect("/collections", status=301)
        db=sql.connect("database.db")
        print("----------IM HEREEE BITCHES------")
        print(token)
        #username=db.execute("SELECT name FROM Users WHERE token ='{}';".format(token)).fetchall()
        username=db.execute("SELECT name FROM Users WHERE token =?;",(token,)).fetchall()
        # username = [(None,)]
        print("username_before: ",username)
        if username[0][0] == None:
            #username = db.execute("SELECT user FROM Users WHERE token ='{}';".format(token)).fetchall()
            username = db.execute("SELECT user FROM Users WHERE token =?;",(token,)).fetchall()
        print("username: ",username[0][0])
        db.close()
        return json.dumps(username[0][0])

    @cherrypy.expose
    def change_username(self,token,newUsername):
        print("---------CHANGING USERNAME-------------")

        if token == None:
            raise cherrypy.HTTPRedirect("/collections", status=301)
        if newUsername == "":
            return json.dumps("empty username")
        
        print("---------CHANGING USERNAME-------------")
        print("newUsername: ",newUsername)
        db=sql.connect("database.db")
        #db.execute("UPDATE Users SET name = '{}' WHERE token = '{}';".format(newUsername,token))
        db.execute("UPDATE Users SET name = ? WHERE token = ?;",(newUsername,token))
        db.commit()
        db.close()
        return json.dumps("changed username")
    
    @cherrypy.expose
    def check_password(self,token,password):
        if token == None:
            raise cherrypy.HTTPRedirect("/collections", status=301)
        if password =="":
            return json.dumps("empty password")
        print("---------CHECKING PASSWORD-------------")
        db=sql.connect("database.db")
        #current_password = db.execute("SELECT password FROM Users WHERE token ='{}';".format(token)).fetchall()
        current_password = db.execute("SELECT password FROM Users WHERE token =?;",(token,)).fetchall()
        db.close()

        password = hashlib.sha256(password.encode()).hexdigest()

        print("password: ",password, "current_password: ",current_password)
        if password != current_password[0][0]:
            return json.dumps("wrong password")
        else:
            return json.dumps("correct password")

    @cherrypy.expose
    def change_password(self,token,newPassword):
        result = {"DONE": "YES", "ERROR": ""}

        if token == None:
            raise cherrypy.HTTPRedirect("/collections", status=301)
        if newPassword == "":
            result["DONE"] = "NO"
            result["ERROR"] = "empty password"
            return json.dumps(result)
        print("---------CHANGING PASSWORD-------------")
        db=sql.connect("database.db")
        #db.execute("UPDATE USERS SET password = '{}' WHERE token = '{}';".format(newPassword,token))
        res = check_password_requirements(newPassword)
        if res[0] == False:
            result["DONE"] = "NO"
            result["ERROR"] = res[1]
            return json.dumps(result)

        newPassword = hashlib.sha256(newPassword.encode()).hexdigest()
        
        db.execute("UPDATE USERS SET password = ? WHERE token = ?;",(newPassword,token))
        db.commit()
        #print("newpassword: ",db.execute("SELECT password FROM Users WHERE token ='{}';".format(token)).fetchall())
        print("newpassword: ",db.execute("SELECT password FROM Users WHERE token =?;",(token,)).fetchall())
        db.close()
        return json.dumps(result)



    



