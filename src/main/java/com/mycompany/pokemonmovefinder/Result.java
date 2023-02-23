package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.StringFormatter;
import com.mycompany.pokeapilibrary.pokemon.PokemonMove;
import java.util.ArrayList;

public class Result {

    private String pkmnName;
    private ArrayList<PokemonMove> moves;
    //remember level learned at 0 is when it is learned some way other than level up
    //TODO add moves and versions etc so that the user can see which versions
    //the pokemon learns some or all of the moves in

    public Result(String pkmnName) {
        this.pkmnName = StringFormatter.basicFormat(pkmnName);
    }    
    
    public Result(String pkmnName, ArrayList<PokemonMove> moves) {
        this.pkmnName = StringFormatter.basicFormat(pkmnName);
        this.moves = moves;
    }

    public String getPkmnName() {
        return pkmnName;
    }

    public void setPkmnName(String pkmnName) {
        this.pkmnName = pkmnName;
    }

    public ArrayList<PokemonMove> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<PokemonMove> moves) {
        this.moves = moves;
    }

    @Override
    public String toString() {
        return "Result{" + "pkmnName=" + pkmnName + ", moves=" + moves + '}';
    }



}
