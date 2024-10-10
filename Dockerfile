# Usa una imagen base de Maven para compilar el proyecto
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app

# Copia el archivo pom.xml y descarga las dependencias del proyecto
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el resto del proyecto y compila
COPY src ./src
RUN mvn clean package -DskipTests

# Usa una imagen base de OpenJDK para correr la aplicación
FROM openjdk:17-jdk-alpine
WORKDIR /app

# Copia el JAR generado en la fase de compilación
COPY --from=build /app/target/lobby-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que usará la aplicación
EXPOSE 8080

# Comando para correr la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
