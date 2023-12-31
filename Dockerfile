#
# Build stage
#
FROM maven:3.9.5 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:20-jdk-slim
COPY --from=build /target/netkaffi-0.0.1-SNAPSHOT.jar netkaffi.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","netkaffi.jar"]
