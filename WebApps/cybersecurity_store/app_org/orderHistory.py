import json
import cherrypy
from utils import *
import sqlite3 as sql

class OrderHistory(object):
    @cherrypy.expose
    def default(self, *url_parts, **params):
        return open("html/order_history.html")

    @cherrypy.expose
    def getOrderHistory(self, token=None):
        if token == None:
            raise cherrypy.HTTPRedirect("/collections", status=301)

        if not validToken(token):
            raise cherrypy.HTTPRedirect("/", status=301)

        db = sql.connect("database.db")
        userId = getUserIdFromToken(token)
        # orderHistory = db.execute("SELECT * FROM OrderHistory WHERE IdUsr='" + str(userId) + "';").fetchall()
        orderHistory = db.execute("SELECT * FROM OrderHistory WHERE IdUsr=?;", (str(userId),)).fetchall()
        if len(orderHistory) < 1:
            return json.dumps({"DONE": "NO"})

        result = {"DONE": "YES", "productsData": []}
        for elem in orderHistory:
            productId = elem[2]
            # productData = db.execute("SELECT ImgPath,name,price FROM Products WHERE Id='" + str(productId) + "';").fetchall()
            productData = db.execute("SELECT ImgPath,name,price FROM Products WHERE Id=?;", (str(productId),)).fetchall()
            result["productsData"].append([
                productData[0][0], # img path
                productData[0][1], # product name
                productData[0][2], # product price
                elem[1], # quantity
                elem[2]  # product id
            ])

        db.close()
        return json.dumps(result)

    @cherrypy.expose
    def addOrder(self,token=None,data=None):
        if token == None:
            raise cherrypy.HTTPRedirect("/collections", status=301)
        
        if not validToken(token):
            raise cherrypy.HTTPRedirect("/", status=301)
        
        if data == None:
            raise cherrypy.HTTPRedirect("/collections", status=301)
        db = sql.connect("database.db")
        userId = getUserIdFromToken(token)
        data = json.loads(data)
        for elem in data:
            # db.execute("INSERT INTO OrderHistory (IdUsr,Quantity,ProductId) VALUES ('" + str(userId) + "','" + str(elem[0]) + "','" + str(elem[2]) + "');")
            db.execute("INSERT INTO OrderHistory (IdUsr,Quantity,ProductId) VALUES (?,?,?);", (str(userId), str(elem[2]), str(elem[4])))
        db.commit()
        db.close()
        return json.dumps({"DONE": "YES"})
