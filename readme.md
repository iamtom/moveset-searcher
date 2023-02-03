# Pokémon Move Finder

## What is it?
The user can choose up to four Pokémon moves and this application will find which
Pokémon, if any, can learn those moves.

Currently it will only return the names of the Pokémon however I intend to
add additional information that should be useful such as what versions the 
Pokémon can learn all the moves in.

This application uses pokeapi.co. The API is accessed using my code which can
be found here: https://github.com/iamtom/poke-api-library

The application uses Spring Boot and Thymeleaf.

## Future Plans
At the moment it only displays the names of the Pokémon that can learn the
selected moves. This is useful but doesn't account for the fact that while yes,
a particular Pokémon may be able to learn those moves, it might not learn them 
all in the version of the game that you're playing.

I will be adding a way for the application to show the user what versions the
Pokémon can learn these moves in.
