# --- Stage 1: Build the app ---
FROM maven:3.9.4-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# --- Stage 2: Run the app ---
FROM eclipse-temurin:21-jdk-alpine AS runner
VOLUME /tmp
WORKDIR /app

# Copy the jar from the builder stage
COPY --from=builder /app/target/user-service-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the app port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]