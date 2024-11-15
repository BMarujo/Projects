import socket

ip_addr = "120.100.20.2"
tcp_port = 5005

client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

client_socket.connect((ip_addr, tcp_port))

data = input("Enter message: ")
client_socket.send(data.encode())

response = client_socket.recv(1024)
response = response.decode()
print(response)

client_socket.close()