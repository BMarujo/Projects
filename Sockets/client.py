#!/usr/bin/python3

import os
import re #import regular expressions
import sys
import socket
import json
import base64
from common_comm import send_dict, recv_dict, sendrecv_dict

from Cryptodome.Cipher import AES
from Cryptodome.Hash import SHA256

# Function to encript values for sending in json format
# return int data encrypted in a 16 bytes binary string coded in base64
# Função para criptografar valores para envio no formato json
# retorna dados int criptografados em uma string binária de 16 bytes codificada em base64
def encrypt_intvalue (cipherkey, data):
	cifra=AES.new(cipherkey, AES.MODE_ECB)
	dados_para_encriptar= ("%16d" % data)
	dados_encriptados=cifra.encrypt(bytes(dados_para_encriptar, "utf8"))
	dados_encriptados_str_b64=str(base64.b64encode(dados_encriptados),"utf8")
	return dados_encriptados_str_b64


# Function to decript values received in json format
# return int data decrypted from a 16 bytes binary strings coded in base64
# Função para descriptografar valores recebidos no formato json
# retorna dados int descriptografados de strings binárias de 16 bytes codificadas em base64
def decrypt_intvalue (cipherkey, data):
	cifra=AES.new(cipherkey, AES.MODE_ECB)
	dados_encriptados=base64.b64decode(data)
	dados_decriptados=cifra.decrypt(dados_encriptados)
	dados_decriptados_utf8=dados_decriptados.decode("utf8")
	return int(dados_decriptados_utf8)


# verify if response from server is valid or is an error message and act accordingly - já está implementada
def validate_response (client_sock, response):
	if not response["status"]:
		print (response["error"])
		client_sock.close ()
		sys.exit (3)


# process QUIT operation
#A função envia uma mensagem para o servidor com a operação "QUIT" e valida a resposta recebida.
def quit_action (client_sock):

	validate_response(client_sock, sendrecv_dict(client_sock, {"op": "QUIT" }))
	client_sock.close()
	sys.exit(4)

# process NUMBER operation

#def number_action (client_sock, input_number, lst, cifra):
#	validate_response(client_sock, sendrecv_dict(client_sock, {"op": "NUMBER", "number": encrypt_intvalue(cifra, int(input_number))}))
#	lst.append(input_number)

#A função envia uma mensagem ao servidor com a operação "NUMBER" e o número fornecido como argumento, e em seguida valida a resposta recebida.

def number_action (client_sock, input_number, lst):
	validate_response(client_sock, sendrecv_dict(client_sock, {"op": "NUMBER", "number": int(input_number)}))
	lst.append(int(input_number))

# process START operation

#def start_action (client_id):
#	cipherkey = os.urandom(16)
#	return {
#            'op': 'START',
#           'client_id': client_id,
#            'cipher': str(base64.b64encode(cipherkey), "utf8")
#        }

def start_action (client_id):
	return {
            'op': 'START',
            'client_id': client_id,
            'cipher': None
        }

# process STOP operation
#O cliente envia uma mensagem ao servidor para parar o jogo atual. 
#O servidor envia uma mensagem de resposta que contem o valor que o cliente tenta adivinhar. Em seguida, a lista de números introduzidos é exibida, juntamente com o número escolhido.
#O cliente então pede ao usuário que escolha entre QUIT (sair) ou GUESS (adivinhar novamente).
def stop_action (client_sock,lst):

	#criar hash da lista de numeros
	string_numbers=str(lst).encode("utf-8")
	valor_sha256=SHA256.new(string_numbers).hexdigest()

	send_dict(client_sock, {"op": "STOP", "shasum":valor_sha256 })

	response2 = recv_dict(client_sock)
	value2 = response2["value"]

	print("\nNúmeros introduzidos -> ",  lst , "\nO numero escolhido pelo server foi:", value2 , "\n")


	option=input("Escolha opção: QUIT (Q/q); GUESS (G/g): ")
	if (option == "Q" or option == "q"):
		quit_action(client_sock)
	while (option != "G" and option != "g"):
		print ("\nOpção inválida\n")
		option=input("Escolha opção: QUIT (Q/q); GUESS (G/g): ")
	#if numbers == 0:
	#	print("Não inseriu nenhum número")
	#	quit_action(client_sock)
	guess= input("\n( Para terminar: QUIT(Q/q) )\nOpções para adivinhar: min / max / first / last / median\nEscolha uma opção-> ")
	if (guess == "Q" or guess == "q"):
		quit_action(client_sock)
	while (guess != "min" and guess != "max" and guess != "first" and guess != "last" and guess != "median"):
		guess= input("\nOpções para adivinhar: min / max / first / last / median\nEscolha uma opção-> ")
	
	guess_action(client_sock, guess)

	request = recv_dict (client_sock)

	response = request["result"]

	print("\nResultado - > ", response, "\n")

	sys.exit(0)



	
# process GUESS operation

def guess_action (client_sock, guess):
	validate_response(client_sock, sendrecv_dict(client_sock, {"op": "GUESS", "choice": guess }))



# Outcomming message structure:
# { op = "START", client_id, [cipher] }
# { op = "QUIT" }
# { op = "NUMBER", number }
# { op = "STOP", [shasum] }
# { op = "GUESS", choice }
#
# Incomming message structure:
# { op = "START", status }
# { op = "QUIT" , status }
# { op = "NUMBER", status }
# { op = "STOP", status, value }
# { op = "GUESS", status, result }

#
# Suport for executing the client pretended behaviour


#Dentro dessa função, uma lista lst é inicializada para guardar os números inseridos pelo cliente.
#A função inicia com a chamada da função start_action, que envia uma mensagem ao servidor para iniciar a comunicação. Em seguida, um menu é apresentado ao cliente para escolher as opções: QUIT (sair), NUMBER (inserir número) e STOP (parar).


def run_client (client_sock, client_id):

	lst = [] # lista para guardar os números inseridos
	start_action_dict = start_action(client_id)
	validate_response(client_sock, sendrecv_dict(client_sock, start_action_dict))
	numbers = 0
	#cifra=start_action_dict["cipher"]
	option=input("\nEscolha opção: QUIT (Q/q); NUMBER (N/n); STOP (S/s): ")

	while (option != "Q" and option != "q"):
		if (option == "N" or option == "n"):
			number=input("\nInsira um número: ")
			while(number.isnumeric() == False):
				print("\nValor inválido\n")
				number=input("\nInsira um número: ")
			number_action(client_sock, number, lst)
			numbers+=1
			print("\nNúmeros inseridos: ", numbers , "\n")
		elif (option == "S" or option == "s"):
			if numbers == 0:
				print("\nNão inseriu nenhum número\n")
			

			else:
				stop_action(client_sock, lst)
				break

		else:
			print ("\nOpção inválida\n")
		option=input("Escolha opção: QUIT (Q/q); NUMBER (N/n); STOP (S/s): ")
	
	quit_action(client_sock)


# check if the string is a valid IPv4 address
def is_ipv4_address(address):
  
    ipv4_regex = re.compile(r'^((\d{1,2}|1\d{2}|2[0-4]\d|25[0-5])\.){3}(\d{1,2}|1\d{2}|2[0-4]\d|25[0-5])$')
    return bool(ipv4_regex.match(address))


def main():
	# validate the number of arguments and eventually print error message and exit with error
	# verify type of of arguments and eventually print error message and exit with error
	# obtain the hostname that can be the localhost or another host
	hostname = "127.0.0.1"

	if (len(sys.argv)==4 or len(sys.argv)==3):
		if (len(sys.argv)==4):
			if (not (is_ipv4_address(sys.argv[3])) and sys.argv[3]!="localhost"):
				print ("error, third argument is not a IPv4 address")
				sys.exit(1)
			else:
				hostname = sys.argv[3]
			if (not (sys.argv[2].isnumeric())):
				print ("error, invalid port number, must be numeric")			
				sys.exit(2)
			if (int(sys.argv[2]) < 1024 or int(sys.argv[2]) > 65535):
				print ("error, port number must be in the range 1024 to 65535")
				sys.exit(2)
		if (len(sys.argv)==3):
			if (not (sys.argv[2].isnumeric())):
				print ("error, invalid port number, must be numeric")		
				sys.exit(2)
			if (int(sys.argv[2]) < 1024 or int(sys.argv[2]) > 65535):
				print ("error, port number must be in the range 1024 to 65535")
				sys.exit(2)
	else:
		print ("error, number of arguments is not correct")
		sys.exit(1)
            
	if len (sys.argv) == 3:
		# Tries to connect to the server and verify if it is a valid address or ip
		test_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
		# Set timeout to 5 seconds to try to resolve the address and connect
		test_socket.settimeout(5)
		try:
			test_socket.connect((hostname, int(sys.argv[2])))
			test_socket.close()
		except:
			#If the address or port is not valid, print error and exit
			test_socket.close()
			print("error, the port is not the same as the server, or the server is not running")
			sys.exit(2)
			
	if len (sys.argv) == 4:
		# Tries to connect to the server and verify if it is a valid address or ip
		test_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
		# Set timeout to 5 seconds to try to resolve the address and connect
		test_socket.settimeout(5)
		try:
			test_socket.connect((sys.argv[3], int(sys.argv[2])))
			test_socket.close()
		except:
			#If the address or port is not valid, print error and exit
			test_socket.close()
			print("error, address must be a valid IPv4 address or localhost, or maybe if you are using localhost, the port is not the same as the server, or maybe the server is not running")
			sys.exit(2)



	# obtain the port number
	port = int(sys.argv[2])

	client_socket = socket.socket (socket.AF_INET, socket.SOCK_STREAM)
	client_socket.bind(("0.0.0.0", 0))
	client_socket.connect ((hostname, port))

	run_client (client_socket, sys.argv[1])

	client_socket.close ()
	sys.exit (0)

if __name__ == "__main__":
    main()
