FROM openjdk:21-jdk-slim

WORKDIR /app

RUN mkdir -p /data

COPY target/file-node-0.0.1.jar app.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "app.jar"]