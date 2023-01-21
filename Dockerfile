FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package

FROM openjdk:11-jdk-slim
COPY --from=build /target/pokemonmovefinder-0.0.1-SNAPSHOT.jar pokemonmovefinder.jar
ENTRYPOINT ["java","-jar","pokemonmovefinder-0.0.1-SNAPSHOT.jar"]