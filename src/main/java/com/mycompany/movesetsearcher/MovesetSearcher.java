package com.mycompany.movesetsearcher;

import com.mycompany.movesetsearcher.tools.MoveSelectDataLoader;
import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovesetSearcher {

    public static void main(String[] args) {
        SpringApplication.run(MovesetSearcher.class, args);
    }

    @Bean
    public CommandLineRunner loadMoveDataDatabase(MoveSelectDataRepository moveDataRepository) {
        return (args) -> {
            System.out.println("Loading the moveSelectDataRepository.");
            long start = System.nanoTime();
            
            ArrayList<MoveSelectData> moveSelectList = MoveSelectDataLoader.loadFromAPI();
            moveDataRepository.saveAll(moveSelectList);
            
            long end = System.nanoTime();
            double durationInMilliseconds = 1.0 * (end - start) / 1000000;
            System.out.println("Finished loading moveSelectDataRepository in "
                    + durationInMilliseconds + " ms.");
        };
    }

}
