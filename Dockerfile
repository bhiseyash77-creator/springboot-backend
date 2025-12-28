# --------------------------
# Build Stage
# --------------------------
FROM maven:3.9.3-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml first (for caching dependencies)
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the project (skip tests for faster build)
RUN mvn clean package -DskipTests

# --------------------------
# Run Stage
# --------------------------
FROM eclipse-temurin:17-jre

# Set working directory
WORKDIR /app

# Copy the jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8787

# Run the application
CMD ["java", "-jar", "app.jar"]
