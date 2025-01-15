# Use a lightweight OpenJDK base image
FROM openjdk:21-jdk-slim as builder

# Set the working directory
WORKDIR /app

# Copy the entire project (assuming a Gradle/Maven build system)
COPY . .

# Build the Spring Boot application
RUN ./gradlew build --no-daemon || ./mvnw package -DskipTests

# Create a minimal runtime image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Add a health check (optional)
HEALTHCHECK --interval=30s --timeout=10s --start-period=10s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
