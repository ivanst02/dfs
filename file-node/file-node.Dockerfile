FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/file-node-0.0.1.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]