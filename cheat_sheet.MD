

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

docker network creation
docker network create micro_cards

Run infrastructure containers
docker run -d --name=consul --network=micro_cards -p 8500:8500 consul
docker run -d --name=rabbitmq --network=micro_cards -p 15672:15672 rabbitmq:3-management

Run our containers
docker run --network=micro_cards -p 8080:8080 resolver:0.0.1
docker run --network=micro_cards -p 8082:8082 recorder:0.0.1
docker run --network=micro_cards -p 8081:8081 ongoing:0.0.1