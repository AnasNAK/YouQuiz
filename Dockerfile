FROM openjdk:17-jdk-slim

WORKDIR /app

ENTRYPOINT ["java", "-jar", "YouQuiz-0.0.1-SNAPSHOT.jar"]