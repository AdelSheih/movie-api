# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:21-jre

# Set the working directory in the container
WORKDIR /app

# Copy the built jar file (the name must match your build output)
COPY target/movie-0.0.1-SNAPSHOT.jar app.jar

# Expose the port (Render will set $PORT)
EXPOSE 8080

# Run the jar file, using the PORT environment variable if set
CMD ["sh", "-c", "java -jar app.jar --server.port=$PORT"]
