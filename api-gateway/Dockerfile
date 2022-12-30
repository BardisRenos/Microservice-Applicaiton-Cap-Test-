FROM openjdk:11.0.15-slim
EXPOSE 8888
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api-gateway.jar
ENTRYPOINT ["java", "-jar", "/api-gateway.jar"]