
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY ./target/demo-0.0.1-SNAPSHOT.jar /app/otis-app.jar
ENTRYPOINT ["java", "-jar", "/otis-app.jar"]

