FROM eclipse-temurin:11 AS build
COPY . .
RUN mvn clean package

FROM eclipse-temurin:11
COPY --from=build /target/pokemonmovefinder-0.0.1-SNAPSHOT.jar pokemonmovefinder.jar
ENTRYPOINT ["java","-jar","pokemonmovefinder-0.0.1-SNAPSHOT.jar"]