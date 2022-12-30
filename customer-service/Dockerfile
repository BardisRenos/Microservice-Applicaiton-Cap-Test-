FROM openjdk:11.0.15-slim
EXPOSE 8083
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} customer-service.jar
ENTRYPOINT ["java", "-jar", "/customer-service.jar"]