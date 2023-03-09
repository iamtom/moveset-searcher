package com.mycompany.pokemonmovefinder.results;

import com.mycompany.pokeapilibrary.StringFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class ResultMoveData {
    private String moveName;
    private HashMap<String, String> learnMethods; //e.g. key level-up, value 20

    public ResultMoveData(String moveName, HashMap<String, String> learnMethods) {
        this.moveName = StringFormatter.basicFormat(moveName);
        this.learnMethods = learnMethods;
    }
    
    
    
}
