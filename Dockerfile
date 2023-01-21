FROM eclipse-temurin:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} pokemonmovefinder-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/pokemonmovefinder-0.0.1-SNAPSHOT.jar"]