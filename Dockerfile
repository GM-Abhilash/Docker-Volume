FROM openjdk:11

WORKDIR /app

ARG JAR_FILE="target/docker-app-1.0.jar"

COPY ${JAR_FILE} app.jar

ENV PORT 9002

VOLUME [ "/app/temp" ]

ENTRYPOINT [ "java" , "-jar" , "app.jar"]