# Build stage
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

RUN ls -l /app/target/
RUN ls -l /app/src/main/resources/

# Runtime stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/registration-login-demo-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/application.properties application.properties



EXPOSE 38081

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.location=application.properties"]


