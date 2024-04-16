FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

COPY pom.xml .
COPY commons/src ./commons/src
COPY commons/pom.xml ./commons/
COPY web/src ./web/src
COPY web/pom.xml ./web/

RUN mvn clean package -DskipTests

FROM openjdk:17-slim

WORKDIR /app

COPY --from=build /app/web/target/*.jar /app/*.jar

CMD ["java", "-jar", "/app/*.jar"]