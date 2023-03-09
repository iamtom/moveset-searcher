package com.mycompany.pokemonmovefinder.results;

import com.mycompany.pokeapilibrary.StringFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class PokemonMoveResultData {
    private String moveName;
    private HashMap<String, String> learnMethods; //e.g. key level-up, value 20

    public PokemonMoveResultData(String moveName, HashMap<String, String> learnMethods) {
        this.moveName = StringFormatter.basicFormat(moveName);
        this.learnMethods = learnMethods;
    }

    public String getMoveName() {
        return moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }

    public HashMap<String, String> getLearnMethods() {
        return learnMethods;
    }

    public void setLearnMethods(HashMap<String, String> learnMethods) {
        this.learnMethods = learnMethods;
    }

    @Override
    public String toString() {
        return "PokemonMoveResultData{" + "moveName=" + moveName + ", learnMethods=" + learnMethods + '}';
    }

}
