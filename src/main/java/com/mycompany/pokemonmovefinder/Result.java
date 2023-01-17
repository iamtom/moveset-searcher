package com.mycompany.pokemonmovefinder;

import java.util.List;


public class Result {
    
    private String pkmnName;
    //TODO add moves and versions etc so that the user can see which versions
    //the pokemon learns some or all of the moves in
    
    public Result(String pkmnName) {
        this.pkmnName = pkmnName;
        //TODO format the name nicely
    }

    public String getPkmnName() {
        return pkmnName;
    }

    @Override
    public String toString() {
        return "Result{" + "pkmnName=" + pkmnName + '}';
    }
    
}
