package com.mycompany.pokemonmovefinder;

import com.mycompany.pokemonmovefinder.tools.MoveSelectDataLoader;
import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PokemonMoveFinder {

    public static void main(String[] args) {
        SpringApplication.run(PokemonMoveFinder.class, args);
    }

    @Bean
    public CommandLineRunner loadMoveDataDatabase(MoveSelectDataRepository moveDataRepository) {
        return (args) -> {
            System.out.println("Loading the moveSelectDataRepository.");
            long start = System.nanoTime();
            ArrayList<MoveSelectData> moveSelectList = MoveSelectDataLoader.getArrayListOfMoveSelectDataFromAPI();
            moveDataRepository.saveAll(moveSelectList);
            long end = System.nanoTime();
            double durationInMilliseconds = 1.0 * (end - start) / 1000000;
            System.out.println("Finished loading moveSelectDataRepository in "
                    + durationInMilliseconds + " ms.");
        };
    }

}
