package com.mycompany.pokemonmovefinder.results;

import com.mycompany.pokeapilibrary.StringFormatter;
import java.util.ArrayList;

public class MoveResultData {

    private String moveName;
    private ArrayList<String> learnMethods;

    public MoveResultData(String moveName, ArrayList<String> learnMethods) {
        this.moveName = StringFormatter.basicFormat(moveName);
        this.learnMethods = learnMethods;
    }

    public String getMoveName() {
        return moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }

    public ArrayList<String> getLearnMethods() {
        return learnMethods;
    }

    public void setLearnMethods(ArrayList<String> learnMethods) {
        this.learnMethods = learnMethods;
    }

    @Override
    public String toString() {
        return "PokemonVersionResultData{" + "moveName=" + moveName + ", learnMethods=" + learnMethods + '}';
    }
}
