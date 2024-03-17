# Step 1: Use the official Maven image for the build stage
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src
# Build the application
RUN mvn clean package -DskipTests

# Step 2: Use the OpenJDK image for the runtime stage
FROM openjdk:17-slim
WORKDIR /app
# Copy the built artifact from the build stage
COPY --from=build /app/target/*.jar app.jar
# Expose the port the application runs on
EXPOSE 8080
# Run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
