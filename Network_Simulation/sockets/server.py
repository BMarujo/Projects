import socket

ip_addr = "0.0.0.0"

tcp_port = 5005

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

server_socket.bind((ip_addr, tcp_port))

server_socket.listen()

client_byte_counts = {}

while True:

  client_socket, client_address = server_socket.accept()

  print(f"Received connection from {client_address}")

  data = client_socket.recv(1024)

  data = data.decode()

  print(f"Received data: {data}")

  hostname = socket.gethostname()

  ip_address = socket.gethostbyname(hostname)

  client_byte_counts[client_address] = client_byte_counts.get(client_address, 0) + len(data)

  total_bytes = sum(client_byte_counts.values())

  response = f"Hostname: {hostname}\nIP address: {ip_address}\nTotal bytes received: {total_bytes}"

  client_socket.send(response.encode())

  client_socket.close()