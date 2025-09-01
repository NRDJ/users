Usuarios

Listar todos:
http://localhost:8081/api/users

Por ID:
http://localhost:8081/api/users/1

Por email:
http://localhost:8081/api/users/by-email?email=pedro@example.com

Roles de un usuario:
http://localhost:8081/api/users/1/roles

Direcciones de un usuario:
http://localhost:8081/api/users/1/addresses

Login Demo:

Correcto:
http://localhost:8081/api/auth/login?email=pedro@example.com&password=Pedro123!

Incorrecto:
http://localhost:8081/api/auth/login?email=ana@example.com&password=wrong
