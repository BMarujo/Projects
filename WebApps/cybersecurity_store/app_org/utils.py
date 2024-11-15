import sqlite3 as sql
from PIL import Image, ImageFont, ImageDraw
import hashlib

def check_password_requirements(password):
    print("CHECKING REQUIREMENTS")
    special_chars =  ["$", "&", "!"]
    if len(password) < 8:
        return(False, "A password deve ter pelo menos 8 caracteres.")
    elif not any(char.isdigit() for char in password) :
        return(False, "A password deve conter pelo menos um numero.")
    elif not any(char.isupper() for char in password):
        return(False, "A password deve ter pelo menos uma letra maiuscula.")
    elif not any(char.islower() for char in password):
        return(False, "A password deve ter pelo menos uma letra minuscula.")
    elif not any(char in special_chars for char in password):
        return(False, "A password deve ter pelo menos um caracter especial [\"$\", \"&\", \"!\"].")
    else: 
        return (True, "")

def signin(nome, password):
    res = check_password_requirements(password)
    if res[0]:
        db = sql.connect("database.db")
        user = db.execute("SELECT * FROM Users WHERE user = ?", (nome,)).fetchall()
        if len(user) != 0:
            db.close()
            return (False, "User alread exists.")

        # Encrypt password with sha256, using the hashlib library, so that the password is not stored in plain text
        password = hashlib.sha256(password.encode()).hexdigest()

        # Check if the password was encrypted correctly
        #print(password)
        cursor = db.cursor()
        cursor.execute("INSERT INTO Users(user,password) VALUES(?, ?)", (nome, password))
        db.commit()
        db.close()
        return (True, "")
    else:
        return res

def login(nome, password):
    db = sql.connect("database.db")
    
    # Encrypt password with sha256, so that it can be compared with the encrypted password in the database
    password = hashlib.sha256(password.encode()).hexdigest()

    # Check if the password was encrypted correctly
    #print(password)
    
    user = db.execute("SELECT * FROM Users WHERE user = ? AND password = ?", (nome, password)).fetchall()
    if len(user) == 0:
        db.close()
        return False

    db.close()
    return True

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

def getCollections(token):
    result = []
    db = sql.connect("database.db")
    userCollectionsIds = db.execute("SELECT idCollection FROM Users WHERE token = ?", (token,)).fetchall()
    if len(userCollectionsIds) == 0:
        db.close()
        return result
    else:
        for collection_id_tuple in userCollectionsIds:
            if collection_id_tuple[0] != None:
                col_ids = collection_id_tuple[0].split(";")
                for col_id in col_ids:
                    # info = db.execute("SELECT * FROM Collection WHERE id = '" + col_id + "';").fetchall()
                    info = db.execute("SELECT * FROM Collection WHERE id = ?", (col_id)).fetchall()
                    if len(info) != 0:
                        result.append([info[0][0], info[0][1]])
    db.close()
    return result

def getImages(token):
    result = []
    if not validToken(token):
        print("invalid token")
        return result
    db = sql.connect("database.db")
    paths = db.execute("SELECT path FROM ServerImgs").fetchall()
    if len(paths) == 0:
        db.close()
        return result
    else:
        for path in paths:
            result.append(path[0])          
    db.close()
    return result

def getUserProducts(token, update=0):        # o update vai ser o id do produto que foi adicionado
    result = []
    if not validToken(token):
        print("invalid token")
        return result

    db = sql.connect("database.db")
    # userId = db.execute("SELECT Id FROM Users WHERE token = '" + token + "';").fetchall()[0][0]
    userId = db.execute("SELECT Id FROM Users WHERE token = ?", (token,)).fetchall()[0][0]
    print("-----------userId: {}--------------".format(userId))
    # products = db.execute("SELECT Products.* FROM Products JOIN UserProducts ON Products.Id = UserProducts.ProductId WHERE UserProducts.UserId = {};".format(userId)).fetchall()
    products = db.execute("SELECT Products.* FROM Products JOIN UserProducts ON Products.Id = UserProducts.ProductId WHERE UserProducts.UserId = ?", (userId,)).fetchall()
    print("----------------------------------------")
    print(products)
    print("----------------------------------------")
    if update != 0:
        # old_quantity = db.execute("SELECT Quantity FROM UserProducts WHERE ProductId = {};".format(update)).fetchall()[0][0]
        old_quantity = db.execute("SELECT Quantity FROM UserProducts WHERE ProductId = ?", (update,)).fetchall()[0][0]
        # db.execute("UPDATE UserProducts SET Quantity = {} WHERE UserId = {};".format(old_quantity+1,userId))
        db.execute("UPDATE UserProducts SET Quantity = ? WHERE UserId = ?", (old_quantity+1,userId))
        db.commit()
    else:
        if len(products) == 0:
            db.close()
            return result
        else:
            for product in products:    # product = [id, path, comment,quantity, name, price]
                id = product[0]
                path = product[1]
                # quantity = db.execute("SELECT Quantity FROM UserProducts WHERE ProductId = {} AND userID={};".format(id,userId)).fetchall()[0][0]
                quantity = db.execute("SELECT Quantity FROM UserProducts WHERE ProductId = ? AND userID=?", (id,userId)).fetchall()[0][0]
                productQuantity = db.execute("SELECT quantity FROM Products WHERE Id = {};".format(id)).fetchall()[0][0]
                print("quantity: {}".format(quantity))
                product_name = product[-2]
                price = product[-1]
                result.append([product_name, path, quantity, price,id,productQuantity])          
    db.close()
    return result

def removeUserProduct(token,productId):
    print("------------------------removeUserProduct-----------------------")
    if not validToken(token):
        print("invalid token ON removeUserProduct")
        return 

    if productId == None:
        print("productId is None")
        return 
    #print("productId: {}".format(productId))
    db = sql.connect("database.db")
    # userId = db.execute("SELECT Id FROM Users WHERE token = '" + token + "';").fetchall()[0][0]
    userId = db.execute("SELECT Id FROM Users WHERE token = ?", (token,)).fetchall()[0][0]
    #print("userId: {}".format(userId))
    # quantity = db.execute("SELECT Quantity FROM UserProducts WHERE ProductId = {} AND USERID = {};".format(productId,userId)).fetchall()[0][0]
    quantity = db.execute("SELECT Quantity FROM UserProducts WHERE ProductId = ? AND USERID = ?", (productId,userId)).fetchall()[0][0]
    #print("quantity: {}".format(quantity))
    # db.execute("UPDATE Products SET quantity = quantity + {} WHERE Id = {};".format(quantity,productId))
    db.execute("UPDATE Products SET quantity = quantity + ? WHERE Id = ?", (quantity,productId))
    # executed = "DELETE FROM UserProducts WHERE UserId = {} AND ProductId = {};".format(userId,productId)
    db.execute("DELETE FROM UserProducts WHERE UserId = ? AND ProductId = ?", (userId,productId))
    db.commit()    

    db.close()

def removeAllUserProducts(token):
    if not validToken(token):
        print("invalid token ON removeUserProduct")
        return 

    db = sql.connect("database.db")
    # userId = db.execute("SELECT Id FROM Users WHERE token = '" + token + "';").fetchall()[0][0]
    userId = db.execute("SELECT Id FROM Users WHERE token = ?", (token,)).fetchall()[0][0]
    # db.execute("DELETE FROM UserProducts WHERE UserId = {};".format(userId))
    db.execute("DELETE FROM UserProducts WHERE UserId = ?", (userId,))
    # print to see if it was deleted
    print("DELETE FROM UserProducts WHERE UserId = {}".format(userId))
    for product in db.execute("SELECT * FROM UserProducts WHERE UserId = ?", (userId,)).fetchall():
        print("it was not deleted")
        print(product)
    db.commit()    
    db.close()

# FUNÇÃO FEITA PARA A PÁGINA DO CARRINHO ONDE SE ESTÁ A AUMENTAR OU DIMINUIR A QUANTIDADE DO PRODUTO
def updateUserQuantity(token,productId,newQuantity):     # addToQuantity should be equal to 1 or -1
    print("------------------------newQuantity-----------------------")
    if not validToken(token):
        print("invalid token ON removeUserProduct")
        return 

    if productId == None:
        print("productId is None")
        return

    #print("productId: {}".format(productId))
    db = sql.connect("database.db")
    # userId = db.execute("SELECT Id FROM Users WHERE token = '" + token + "';").fetchall()[0][0]
    userId = db.execute("SELECT Id FROM Users WHERE token = ?", (token,)).fetchall()[0][0]
    #print("userId: {}".format(userId))
    print("newQuantity: {}".format(newQuantity))
    oldQuantity = db.execute("SELECT Quantity FROM UserProducts WHERE ProductId = ?", (productId,)).fetchone()[0]
    print("oldQuantity: {}".format(oldQuantity))
    quantityToAdd = oldQuantity - int(newQuantity) 
    print("quantityToAdd: {}".format(quantityToAdd))
    #print("quantity: {}".format(quantity))
    oldProductQuantity = db.execute("SELECT quantity FROM Products WHERE Id = ?", (productId,)).fetchone()[0]
    newProductQuantity = oldProductQuantity + quantityToAdd
    if newProductQuantity >= 0:
        # db.execute("UPDATE Products SET quantity = {} WHERE Id = {};".format(newProductQuantity,productId))    
        db.execute("UPDATE Products SET quantity = ? WHERE Id = ?", (newProductQuantity,productId))    
        db.execute("UPDATE UserProducts SET Quantity = ? WHERE UserId = ? AND ProductId = ?", (newQuantity,userId,productId))
        db.commit()
        db.close()
        return "Quantidade Atualizada"
    else:
        db.close()
        return "Quantidade Inválida"
    
def collectionExists(nomeCollection):
    db = sql.connect("database.db")
    # collectionResult = db.execute("SELECT * FROM Collection WHERE name = '" + nomeCollection + "';").fetchall()
    collectionResult = db.execute("SELECT * FROM Collection WHERE name = ?", (nomeCollection,)).fetchall()
    db.close()
    return len(collectionResult) != 0

def createCollection(token, nomeCollection):
    if not collectionExists(nomeCollection):
        db = sql.connect("database.db")
        cursor = db.cursor()
        # cursor.execute("INSERT INTO Collection(name) VALUES('" + nomeCollection + "');")
        cursor.execute("INSERT INTO Collection(name) VALUES(?)", (nomeCollection,))
        addCollection(token, cursor.execute("SELECT id FROM Collection WHERE name = ?", (nomeCollection,)).fetchall()[0][0], cursor)
        db.commit()
        db.close()

def addCollection(token, idCollection, cursor):
    # collectionId = cursor.execute("SELECT idCollection FROM Users WHERE token = '" + token + "';").fetchall()
    collectionId = cursor.execute("SELECT idCollection FROM Users WHERE token = ?", (token,)).fetchall()
    # check if the return value is not an empty list
    if len(collectionId) != 0:
        if collectionId[0][0] != None:
            collectionId = collectionId[0][0] + ";" + str(idCollection)
            # cursor.execute("UPDATE Users SET idCollection = '" + collectionId + "' WHERE token = '" + token + "';")
            cursor.execute("UPDATE Users SET idCollection = ? WHERE token = ?", (collectionId, token))
        else:
            # cursor.execute("UPDATE Users SET idCollection = '" + str(getNextCollectionId()) + "' WHERE token = '" + token + "';")
            cursor.execute("UPDATE Users SET idCollection = ? WHERE token = ?", (str(getNextCollectionId()), token))
    else:
        # cursor.execute("UPDATE Users SET idCollection = '" + str(getNextCollectionId()) + "' WHERE token = '" + token + "';")
        cursor.execute("UPDATE Users SET idCollection = ? WHERE token = ?", (str(getNextCollectionId()), token))

def addImage(pathImg, collectionName):
    db = sql.connect("database.db")
    cursor = db.cursor()
    # cursor.execute("INSERT INTO Img(path) VALUES('" + pathImg + "');")
    cursor.execute("INSERT INTO Img(path) VALUES(?);", (pathImg,))
    # idImg = cursor.execute("SELECT IdImg FROM Img WHERE path = '" + pathImg + "';").fetchall()
    idImg = cursor.execute("SELECT IdImg FROM Img WHERE path = ?;", (pathImg,)).fetchall()
    # collectionImgsIds = cursor.execute("SELECT IdImg FROM Collection WHERE name = '" + collectionName + "';").fetchall()
    collectionImgsIds = cursor.execute("SELECT IdImg FROM Collection WHERE name = ?", (collectionName,)).fetchall()

    # check if the return values are not empty lists
    if len(collectionImgsIds) != 0 and len(idImg) != 0:
        if collectionImgsIds[0][0] != None:
            collectionImgsIds = collectionImgsIds[0][0] + ";" + str(idImg[0][0])
            # cursor.execute("UPDATE Collection SET IdImg = '" + collectionImgsIds + "' WHERE name = '" + collectionName + "';")
            cursor.execute("UPDATE Collection SET IdImg = ? WHERE name = ?", (collectionImgsIds, collectionName))
        else:
            # cursor.execute("UPDATE Collection SET IdImg = '" + str(getNextImageId()) + "' WHERE name = '" + collectionName + "';")
            cursor.execute("UPDATE Collection SET IdImg = ? WHERE name = ?", (str(getNextImageId()), collectionName))
    else:
        # cursor.execute("UPDATE Collection SET IdImg = '" + str(getNextImageId()) + "' WHERE name = '" + collectionName + "';")
        cursor.execute("UPDATE Collection SET IdImg = ? WHERE name = ?", (str(getNextImageId()), collectionName))

    db.commit()
    db.close()

def getNextCollectionId():
    db = sql.connect("database.db")
    lastId = len(db.execute("SELECT id FROM Collection").fetchall())
    db.close()
    return lastId + 1

def getNextImageId():
    db = sql.connect("database.db")
    lastId = len(db.execute("SELECT IdImg FROM Img").fetchall())
    db.close()
    return lastId + 1

def collectionBelongsToUser(collectionId, token, db=None):
    if db == None:
        db = sql.connect("database.db")
    # user_collection_ids = db.execute("SELECT idCollection FROM Users WHERE token = '" + token + "';").fetchall()
    user_collection_ids = db.execute("SELECT idCollection FROM Users WHERE token = ?", (token,)).fetchall()
    if db == None:
            db.close()
    if len(user_collection_ids) == 0:
        return False
    elif user_collection_ids[0][0] == None:
        return False
    elif str(collectionId) in user_collection_ids[0][0]:
        return True
    else:
        return False

def getCollectionImgs(collectionId, token):
    result = []
    if not collectionBelongsToUser(collectionId, token):
        result.append("REDIRECT")
        return result

    db = sql.connect("database.db")
    # collectionImgsIds = db.execute("SELECT IdImg FROM Collection WHERE id = '" + collectionId + "';").fetchall()
    collectionImgsIds = db.execute("SELECT IdImg FROM Collection WHERE id = ?", (collectionId,)).fetchall()
    if len(collectionImgsIds) == 0:
        db.close()
        return result
    else:
        for collection_img_id_tuple in collectionImgsIds:
            if collection_img_id_tuple[0] != None:
                imgs_ids = collection_img_id_tuple[0].split(";")
                for img_id in imgs_ids:
                    # img_path = db.execute("SELECT path FROM Img WHERE IdImg = '" + img_id + "';").fetchall()
                    img_path = db.execute("SELECT path FROM Img WHERE IdImg = ?", (img_id,)).fetchall()
                    if len(img_path) != 0:
                        result.append([img_id, img_path[0][0]])
    db.close()
    return result

def userHasCollections(username, db):
    # return db.execute("SELECT idCollection FROM Users WHERE user = '" + username + "';").fetchall()[0][0] != None
    return db.execute("SELECT idCollection FROM Users WHERE user = ?", (username,)).fetchall()[0][0] != None

def getUsernameFromToken(token, db=None):
    if db == None:
        db = sql.connect("database.db")
    # user_name = db.execute("SELECT user FROM Users WHERE token = '" + token + "';").fetchall()
    user_name = db.execute("SELECT user FROM Users WHERE token = ?", (token,)).fetchall()
    if db == None:
        db.close()
    return user_name[0][0]

def getUserIdFromToken(token, db=None):
    if db == None:
        db = sql.connect("database.db")
    # user_name = db.execute("SELECT Id FROM Users WHERE token = '" + token + "';").fetchall()
    user_name = db.execute("SELECT Id FROM Users WHERE token = ?", (token,)).fetchall()
    if db == None:
        db.close()
    return user_name[0][0]

"""def saveImage(token, img_path):
    # convert image to png
    image = Image.open(img_path)
    image.save(img_path)

    username = getUsernameFromToken(token)

    # draw the username (watermark)
    image = Image.open(img_path)
    font = ImageFont.truetype("fonts/Roboto-Italic.ttf", 20)
    draw = ImageDraw.Draw(image)
    position = (5, image.height - 25)
    draw.text(position, username, font=font, fill="white")

    # save the image with sthe watermark
    image.save(img_path)"""

def getCollectionNameFromId(collectionId, cursor):
    # return cursor.execute("SELECT name FROM Collection WHERE id = '" + collectionId + "';").fetchall()[0][0]
    return cursor.execute("SELECT name FROM Collection WHERE id = ?", (collectionId,)).fetchall()[0][0]

def getCollectionIdFromName(collectionName):
    db = sql.connect("database.db")
    # collection_id = db.execute("SELECT id FROM Collection WHERE name = '" + collectionName + "';").fetchall()[0][0]
    collection_id = db.execute("SELECT id FROM Collection WHERE name = ?", (collectionName,)).fetchall()[0][0]
    db.close()
    return collection_id
