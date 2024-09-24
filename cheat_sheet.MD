

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
