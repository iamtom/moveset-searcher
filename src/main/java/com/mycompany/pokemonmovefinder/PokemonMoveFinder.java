package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.SimpleInfo;
import com.mycompany.pokeapilibrary.StringFormatter;
import com.mycompany.pokeapilibrary.move.Moves;
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokemonMoveFinder {

	public static void main(String[] args) {
		SpringApplication.run(PokemonMoveFinder.class, args);
            //TEST
            MovesInput moveNames = new MovesInput();
            moveNames.setMove1("surf");
            moveNames.setMove2("tackle");
            moveNames.setMove3("earthquake");
            moveNames.setMove4("tail-whip");
        
            Search search = new Search(moveNames);
            //System.out.println(search.getUniquePkmnNames());

	}
        


}
