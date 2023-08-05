# Use the official Maven image as the base image
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the project's pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn package

# Use the OpenJDK image as the final base image for running the application
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build stage to the final image
COPY --from=build /app/target/monitoringApplicationUsingGrafana.jar .
COPY src .

EXPOSE 8080

# Run the Java application
CMD ["java", "-jar", "monitoringApplicationUsingGrafana.jar", "--spring.config.location=/app/main/java/com/pankajdets/monitoringApplicationUsingGrafana/config/application.yml"]
