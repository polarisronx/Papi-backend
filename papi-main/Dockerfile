FROM maven:3.8.1-jdk-8-slim as builder

# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY target ./target

# Run the web service on container startup.
CMD ["java","-jar","/app/target/papi-main-0.0.1-SNAPSHOT.jar","--spring.profiles.active=prod"]