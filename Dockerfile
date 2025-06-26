# Use a lightweight official JDK image
FROM eclipse-temurin:21-jdk

# Set working directory inside the container
WORKDIR /app

# Copy the full project into the container
COPY . .

# Build your Spring Boot app using Maven
RUN ./mvnw clean package -DskipTests

# Run the generated JAR
CMD ["java", "-jar", "target/WBJEE-0.0.1-SNAPSHOT.jar"]
