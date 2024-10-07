FROM openjdk:21
COPY ./target/OngoingRound-0.0.1-SNAPSHOT.jar /usr/src/ongoing/
WORKDIR /usr/src/ongoing/
EXPOSE 8081
CMD ["java", "-jar", "OngoingRound-0.0.1-SNAPSHOT.jar"]