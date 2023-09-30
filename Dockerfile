#
# Build stage
#
FROM maven:4.0.0-jdk-20 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:20-jdk-slim
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]