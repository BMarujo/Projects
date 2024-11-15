#!/usr/bin/python3

import sys
import socket
import select
import json
import base64
import csv
import random
from common_comm import send_dict, recv_dict, sendrecv_dict

from Cryptodome.Cipher import AES
from Cryptodome.Hash import SHA256

# Dicionário com a informação relativa aos clientes
users = {}

# return the client_id of a socket or None
def find_client_id (client_sock):
	for client_id in users:
		if users[client_id]["socket"] == client_sock:
			return client_id
	return None


# Função para encriptar valores a enviar em formato json com codificação base64
# return int data encrypted in a 16 bytes binary string and coded base64
def encrypt_intvalue (client_id, data):
	cifra=AES.new(client_id, AES.MODE_ECB)
	dados_para_encriptar= ("%16d" % data)
	dados_encriptados=cifra.encrypt(bytes(dados_para_encriptar, "utf8"))
	dados_encriptados_str_b64=str(base64.b64encode(dados_encriptados),"utf8")
	return dados_encriptados_str_b64


# Função para desencriptar valores recebidos em formato json com codificação base64
# return int data decrypted from a 16 bytes binary string and coded base64
def decrypt_intvalue (client_id, data):
	cifra=AES.new(client_id, AES.MODE_ECB)
	dados_encriptados=base64.b64decode(data)
	dados_decriptados=cifra.decrypt(dados_encriptados)
	dados_decriptados_utf8=dados_decriptados.decode("utf8")
	return int(dados_decriptados_utf8)


# Função auxiliar para gerar o resultado - já está implementada
# return int value and list of description strings identifying the characteristic of the value
def generate_result (list_values):
	
	if len(list_values) % 2 == 1: test = 4
	else : test = 3

	minimal = min(list_values)
	maximal = max(list_values)
	first = list_values[0]
	last = list_values[-1]
		
	choice = random.randint (0, test)
	if choice == 0:
		if minimal == first: return first, ["min", "first"]
		elif maximal == first: return first, ["max", "first"]
		else: return first, ["first"]
	elif choice == 1:
		if minimal == last: return last, ["min", "last"]
		elif maximal == last: return last, ["max", "last"]
		else: return last, ["last"]
	elif choice == 2:
		if minimal == first: return first, ["min", "first"]
		elif minimal == last: return last, ["min", "last"]
		else: return minimal, ["min"]
	elif choice == 3:
		if maximal == first: return first, ["max", "first"]
		elif maximal == last: return last, ["max", "last"]
		else: return maximal, ["max"]
	elif choice == 4:
		list_values.sort()
		median = list_values[len(list_values) // 2]
		if median == first: return first, ["median", "first"]
		elif median == last: return last, ["median", "last"]
		else: return median, ["median"]
	else:
		return None


# Incomming message structure:
# { op = "START", client_id, [cipher] }
# { op = "QUIT" }
# { op = "NUMBER", number }
# { op = "STOP", [shasum] }
# { op = "GUESS", choice }
#
# Outcomming message structure:
# { op = "START", status }
# { op = "QUIT" , status }
# { op = "NUMBER", status }
# { op = "STOP", status, value }
# { op = "GUESS", status, result }


#
# Suporte de descodificação da operação pretendida pelo cliente - já está implementada
#
def new_msg (client_sock):
	request = recv_dict (client_sock)
	# print( "Command: %s" % (str(request)) )

	op = request["op"]
	if op == "START":
		response = new_client (client_sock, request)
	elif op == "QUIT": # 
		response = quit_client (client_sock, request)
	elif op == "NUMBER": # 
		response = number_client (client_sock, request)
	elif op == "STOP": # 
		response = stop_client (client_sock, request)
	elif op == "GUESS": # 
		response = guess_client (client_sock, request)
	else:
		response = { "op": op, "status" : False, "error": "Operação inexistente" }

	# print (response)
	send_dict (client_sock, response )

#
# Suporte da criação de um novo cliente - operação START
#
# detect the client in the request
# verify the appropriate conditions for executing this operation
# process the client in the dictionary
# return response message with or without error message
def new_client (client_sock, request):   

	if request["cipher"] == None:
		cifra = None
	else:
		cifra = base64.b64decode(request["cipher"])
	
	cliente = request["client_id"]

	if cliente in users:
		return {"op": "START", "status": False, "error": "Cliente existente"}
	else:
		
		users[cliente] = {"socket": client_sock, "cipher": cifra, "numbers":[]}
		print("Client %s added\n" % find_client_id (client_sock))
		return {"op": "START", "status": True}
		



#
# Suporte da eliminação de um cliente - já está implementada
#
# obtain the client_id from his socket and delete from the dictionary
def clean_client (client_sock):
	client_id = find_client_id (client_sock)
	if client_id != None:
		print ("Client %s removed\n" % client_id)
		del users[client_id]


#
# Suporte do pedido de desistência de um cliente - operação QUIT
#
# obtain the client_id from his socket
# verify the appropriate conditions for executing this operation
# process the report file with the QUIT result
# eliminate client from dictionary using the function clean_client
# return response message with or without error message
def quit_client (client_sock, request):
	client_id = find_client_id (client_sock)
	if client_id in users:
		print(request["op"] , " operation processed\n")
		update_file(client_id, len(users[client_id]["numbers"]), request["op"]) 
		clean_client(client_sock)
		return {"op": "QUIT", "status": True}
	else:
		return {"op": "QUIT", "status": False, "error": "Cliente inexistente"}


#
# Suporte da criação de um ficheiro csv com o respectivo cabeçalho - já está implementada
#
def create_file ():
	with open("result.csv", "w", newline="") as csvfile:
		columns = ["client_id", "number_of_numbers", "result"]

		fw = csv.DictWriter (csvfile, delimiter=",", fieldnames=columns)
		fw.writeheader()


#
# Suporte da actualização de um ficheiro csv com a informação do cliente
#
# update report csv file with the simulation of the client
def update_file (client_id, size, guess):
	with open("result.csv", "a", newline="") as csvfile:
		columns = ["client_id", "number_of_numbers", "result"]

		fw = csv.DictWriter (csvfile, delimiter=",", fieldnames=columns)
		fw.writerow ({"client_id": client_id, "number_of_numbers": size, "result": guess})


#
# Suporte do processamento do número de um cliente - operação NUMBER
#
# obtain the client_id from his socket
# verify the appropriate conditions for executing this operation
# return response message with or without error message
def number_client (client_sock, request):
	client_id = find_client_id(client_sock)
	if client_id in users:
		print(request["op"] , " operation processed\n")
		if users[client_id]["cipher"] != None:
			users[client_id]["numbers"].append(decrypt_intvalue(users[client_id]["cipher"], request["number"]))

		else:
			users[client_id]["numbers"].append(int(request["number"]))

		return {"op": "NUMBER", "status": True}
	
	else:
		return {"op": "NUMBER", "status": False, "error": "Cliente inexistente"}


#
# Suporte do pedido de terminação de um cliente - operação STOP
#
# obtain the client_id from his socket
# verify the appropriate conditions for executing this operation
# randomly generate a value to return using the function generate_result
# process the report file with the result
# return response message with result or error message
def stop_client (client_sock, request):
	# ...
	# value, solution = generate_result (users[client_id]["numbers"])
	# ...

	client_id = find_client_id(client_sock)
	if client_id in users:

		#criar hash da lista de numeros
		string_numbers=str(users[client_id]["numbers"]).encode("utf-8")
		valor_sha256=SHA256.new(string_numbers).hexdigest()
		valor_sha256_cliente=request["shasum"]
		#verificar se a hash da lista de numeros do server e a hash da lista de numeros do cliente são iguais
		if valor_sha256 != valor_sha256_cliente:
			print("shasum não é válido\n Hash da lista de números do cliente: ", valor_sha256_cliente, "\n Hash da lista de números do servidor: ", valor_sha256, "\n")
		else:
			print("shasum é válido\n Hash da lista de números do cliente: ", valor_sha256_cliente, "\n Hash da lista de números do servidor: ", valor_sha256, "\n")


		value, solution = generate_result(users[client_id]["numbers"])
		update_file(client_id, len(users[client_id]["numbers"]), solution)
		print(request["op"] , " operation processed\n")

		if users[client_id]["cipher"] != None:
			return {"op": "STOP", "status": True, "value": encrypt_intvalue(users[client_id]["cipher"], value)}
		
		else:
			return {"op": "STOP", "status": True, "value": value}
	else:
		return {"op": "STOP", "status": False, "error": "Cliente inexistente"}
	



#
# Suporte da adivinha de um cliente - operação GUESS
#
# obtain the client_id from his socket
# verify the appropriate conditions for executing this operation
# eliminate client from dictionary
# return response message with result or error message
def guess_client (client_sock, request):
	client_id=find_client_id(client_sock)
	if client_id in users:
		print(request["op"] , " operation processed\n")

		file1 = open("result.csv", "r")
		file2 = open("result.csv", "r")

		y=len(file1.readlines())

		for i in range(y-1):
			file2.readline()

		solution=file2.readline()

		solution2=solution.split(",")
		solution3=int(solution2[1])
		if solution3==1:
			send_dict(client_sock, {"op": "GUESS", "status": True, "result": True})
			clean_client(client_sock)
			return { "op": "GUESS", "status": True, "result": True }

		#print("\n",solution,"\n")
		
		file1.close()
		file2.close()

		if request["choice"] in solution:

			
			send_dict(client_sock, {"op": "GUESS", "status": True, "result": True})
			clean_client(client_sock)
			return { "op": "GUESS", "status": True, "result": True }
		else:
			send_dict(client_sock, {"op": "GUESS", "status": True, "result": False})
			clean_client(client_sock)
			return { "op": "GUESS", "status": True, "result": False }

	else:
		return {"op": "GUESS", "status": False, "error": "Cliente inexistente"}


def main():
	# validate the number of arguments and eventually print error message and exit with error
	# verify type of of arguments and eventually print error message and exit with error
	
	# valida o número de argumentos e eventualmente imprime mensagem de erro e sai com erro
	# verifica o tipo de argumentos e, eventualmente, imprime a mensagem de erro e sai com erro
	if (len(sys.argv)==2):
		if (not (sys.argv[1].isnumeric())):
			print ("error, invalid port number, must be numeric")
			sys.exit(2)
		if (int(sys.argv[1]) < 1024 or int(sys.argv[1]) > 65535):
			print ("error, port number must be in the range 1024 to 65535")
			sys.exit(2)

	else:
		print ("error, number of arguments is not correct")
		sys.exit(1)
		

	# obtain the port number
	port = int(sys.argv[1])

	server_socket = socket.socket (socket.AF_INET, socket.SOCK_STREAM)
	server_socket.bind (("127.0.0.1", port))
	server_socket.listen ()

	clients = []
	create_file ()
	print("Server inicializado")
	


	while True:
		try:
			available = select.select ([server_socket] + clients, [], [])[0]
		except ValueError:
			# Sockets may have been closed, check for that
			for client_sock in clients:
				if client_sock.fileno () == -1: clients.remove (client_sock) # closed
			continue # Reiterate select

		for client_sock in available:
			# New client?
			if client_sock is server_socket:
				newclient, addr = server_socket.accept ()
				clients.append (newclient)
			# Or an existing client
			else:
				# See if client sent a message
				if len (client_sock.recv (1, socket.MSG_PEEK)) != 0:
					# client socket has a message
					##print ("server" + str (client_sock))
					new_msg (client_sock)
				else: # Or just disconnected
					clients.remove (client_sock)
					clean_client (client_sock)
					client_sock.close ()
					break # Reiterate select

if __name__ == "__main__":
	main()
