package com.mycompany.pokemonmovefinder;

import com.mycompany.pokemonmovefinder.tools.MoveFinderTools;
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
        public CommandLineRunner loadMoveDataDatabase(MoveDataRepository moveDataRepository) {
            return (args) -> {
                System.out.println("Loading the moveDataRepository.");
                ArrayList<MoveData> moveSelectList = MoveFinderTools.getArrayListOfMoveDataFromAPI();
                moveDataRepository.saveAll(moveSelectList);        
                System.out.println("Loading of the moveDataRepository complete.");
            };   
        }
        


}
