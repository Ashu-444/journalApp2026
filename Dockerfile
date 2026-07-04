# ===== BUILD STAGE =====
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# pehle pom copy (cache optimize)
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# dependencies download
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# full source copy
COPY src ./src

# build jar
RUN ./mvnw clean package -DskipTests


# ===== RUNTIME STAGE =====
FROM eclipse-temurin:17-jre

WORKDIR /app

# jar copy from build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# run jar
ENTRYPOINT ["java","-jar","app.jar"]