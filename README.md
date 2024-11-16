# Taller_-Mongo-y-Spring-BootF

## Direciones de los curls para Probar

### 1: Para Guardar nueva persona

ejemplo :

curl -X POST http://localhost:8080/api/person -H "Content-Type: application/json" -d '{
    "dni": "8428shas",
    "firstName": "Lina",
    "lastName": "velez",
    "age": 20,
    "address": "12341234",
    "emailAddress": "lina@gmail.com",
    "cellNumber": 3044278256
}'

# Curl para obtener todas las personas
curl -X GET http://localhost:8080/api/person/all


# Curl para obtener todas las personas con nombres en mayúsculas
curl -X GET http://localhost:8080/api/person/all-uppercase


# Curl para obtener todas las personas con nombres repetidos en mayúsculas
curl -X GET http://localhost:8080/api/person/all-uppercase-repeat


# Obtener una persona por su ID

curl -X GET http://localhost:8080/api/person/6736c8815e518e7e444a0986


# Actualizar el número de celular de la persona
curl -X PUT http://localhost:8080/api/person -H "Content-Type: application/json" -d '{
    "id": "6736c8815e518e7e444a0986",
    "cellNumber": 3456781234
}'


# Actualizar la dirección de la persona
curl -X PUT http://localhost:8080/api/person/update-address -H "Content-Type: application/json" -d '{
    "id": "{ID_AQUI}",
    "address": "Nueva Dirección"
}'


# Actualizar el correo electrónico de la persona
curl -X PUT http://localhost:8080/api/person/update-email -H "Content-Type: application/json" -d '{
    "id": "{ID_AQUI}",
    "emailAddress": "nuevoemail@example.com"
}'


# Eliminar una persona
curl -X DELETE http://localhost:8080/api/person -H "Content-Type: application/json" -d '{
    "id": "{ID_AQUI}"
}'