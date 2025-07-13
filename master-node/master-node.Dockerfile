FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/master-node-0.0.1.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]