FROM openjdk:17-jdk-slim

WORKDIR /app

COPY launch_jar/WeatherApp*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]