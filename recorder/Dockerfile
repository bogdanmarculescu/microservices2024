FROM openjdk:21
COPY ./target/recorder-0.0.1-SNAPSHOT.jar /usr/src/recorder/
WORKDIR /usr/src/recorder/
EXPOSE 8082
CMD ["java", "-jar", "recorder-0.0.1-SNAPSHOT.jar"]