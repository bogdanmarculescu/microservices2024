

Starting consul
- a consul agent is started, in development mode, with a name "cards" (name may vary)
- template:
- consul agent -dev -node <nodeName>

- example:
- consul agent -dev -node cards

Starting rabbitMQ
- the rabbitmq server is started ("sudo" for admin priviledges)
sudo rabbitmq-server

Starting individual services
- start services with default properties
mvn spring-boot:run 
- start service with command-line specified port
- template:
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=<portNumber>
- example:
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8083


Docker
docker build -t <tag-service-name-version> .
example:
docker build -t resolver:0.0.1 .

docker network create micro_cards
docker run -d --name=consul --network=micro_cards -p 8500:8500 consul


keycloak:
docker run -p 8080:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:26.0.5 start-dev



curl -X POST "http://localhost:8080/realms/micro2024/protocol/openid-connect/token" \
-H "Content-Type: application/x-www-form-urlencoded" \
-d "client_id=cards_2024" \
-d "client_secret=beUcfHL6BJ90dVhtYo1bo4UwzGs2hHkq" \
-d "username=atester" \
-d "password=tester" \
-d "grant_type=password"