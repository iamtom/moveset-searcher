package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.StringFormatter;


public class Result {
    
    private String pkmnName;
    //TODO add moves and versions etc so that the user can see which versions
    //the pokemon learns some or all of the moves in
    
    public Result(String pkmnName) {
        this.pkmnName = StringFormatter.basicFormat(pkmnName);
    }

    public String getPkmnName() {
        return pkmnName;
    }

    @Override
    public String toString() {
        return "Result{" + "pkmnName=" + pkmnName + '}';
    }
    
}
