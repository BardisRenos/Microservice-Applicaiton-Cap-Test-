FROM openjdk:11.0.15-slim
EXPOSE 8084
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} transaction-service.jar
ENTRYPOINT ["java", "-jar", "/transaction-service.jar"]