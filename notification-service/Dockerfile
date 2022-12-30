FROM openjdk:11.0.15-slim
EXPOSE 8085
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} notification-service.jar
ENTRYPOINT ["java", "-jar", "/notification-service.jar"]