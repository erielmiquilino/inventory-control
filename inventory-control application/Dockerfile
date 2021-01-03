FROM maven:3.6.3-openjdk-15 as build-step
RUN mkdir -p /app
WORKDIR /app
COPY mvnw .
COPY pom.xml .
COPY src src
COPY .mvn .mvn
RUN mvn package

FROM openjdk:15.0.1
COPY --from=build-step /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]