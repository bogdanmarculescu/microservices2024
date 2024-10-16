FROM openjdk:21
VOLUME /tmp
COPY ./target/resolver-0.0.1-SNAPSHOT.jar /usr/src/resolver/
WORKDIR /usr/src/resolver/
EXPOSE 8080
CMD ["java", "-jar", "resolver-0.0.1-SNAPSHOT.jar"]