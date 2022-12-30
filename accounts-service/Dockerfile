FROM openjdk:11.0.15-slim
EXPOSE 8081
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} accounts-service.jar
ENTRYPOINT ["java", "-jar", "/accounts-service.jar"]