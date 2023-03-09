package com.mycompany.pokemonmovefinder.results;

import java.util.ArrayList;

public class PokemonVersionResultData {
    private String versionName;
    private ArrayList<PokemonMoveResultData> pokemonMoveResultData;

    public PokemonVersionResultData(String versionName, ArrayList<PokemonMoveResultData> pokemonMoveResultData) {
        this.versionName = versionName;
        this.pokemonMoveResultData = pokemonMoveResultData;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public ArrayList<PokemonMoveResultData> getPokemonMoveResultData() {
        return pokemonMoveResultData;
    }

    public void setPokemonMoveResultData(ArrayList<PokemonMoveResultData> pokemonMoveResultData) {
        this.pokemonMoveResultData = pokemonMoveResultData;
    }

    @Override
    public String toString() {
        return "PokemonVersionResultData{" + "versionName=" + versionName + ", pokemonMoveResultData=" + pokemonMoveResultData + '}';
    }
    
    
}