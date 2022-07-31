FROM maven:3-openjdk-18-slim AS BUILD

WORKDIR /app

COPY src src/

COPY pom.xml .

COPY flyway.conf .

RUN mvn -f /app/pom.xml -DskipTests clean package

FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=BUILD /app/target/qgasosa-backend-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "qgasosa-backend-0.0.1-SNAPSHOT.jar" ]
