FROM openjdk:11.0.15-slim
EXPOSE 8761
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} discovery-service.jar
ENTRYPOINT ["java", "-jar", "/discovery-service.jar"]