FROM openjdk:17-slim

# Establece la zona horaria a Lima, Perú
ENV TZ=America/Lima

ADD target/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]