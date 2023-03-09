package com.mycompany.pokemonmovefinder;

import com.mycompany.pokemonmovefinder.results.Result;
import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.move.Move;
import com.mycompany.pokeapilibrary.pokemon.Pokemon;
import com.mycompany.pokeapilibrary.pokemon.PokemonMove;
import java.util.ArrayList;
import java.util.Collections;

public class PokemonSearch implements Search {

    private final ArrayList<Move> moveList;
    private ItemMatch itemMatch;
    private Request request;

    public PokemonSearch(ArrayList<Move> moveList) {
        this.moveList = moveList;
        this.request = new Request();
        this.itemMatch = new ItemMatch();
    }

    public ArrayList<Result> getResults() {
        ArrayList<String> pkmnThatLearnAllMoves
                = this.itemMatch.pkmnThatLearnAllMoves(this.moveList);

        Collections.sort(pkmnThatLearnAllMoves);

        ArrayList<Pokemon> pokemonObjects = this.getPokemonObjects(pkmnThatLearnAllMoves);

        ArrayList<String> moveNames = new ArrayList<>();
        for (int i = 0; i < this.moveList.size(); i++) {
            moveNames.add(moveList.get(i).getName());
        }        
        
        ArrayList<Result> results = new ArrayList<>();
        for (Pokemon pokemon : pokemonObjects) {
            ArrayList<PokemonMove> pokemonMoves = this.getPokemonMoves(pokemon, moveNames);
            Result result = Result.createResultGroupedByVersion(pokemon.getName(), pokemonMoves);
            results.add(result);
        }

        return results;
    }

    private ArrayList<PokemonMove> getPokemonMoves(Pokemon pokemon, ArrayList<String> moveNames) {
        ArrayList<PokemonMove> allMoves = pokemon.getMoves();
        ArrayList<PokemonMove> movesWanted = new ArrayList<PokemonMove>();

        for (int i = 0; i < moveNames.size(); i++) {
            String currentMove = moveNames.get(i);

            for (int j = 0; j < allMoves.size(); j++) {
                if (allMoves.get(j).getMove().getName().equals(currentMove)) {
                    movesWanted.add(allMoves.get(j));
                }
            }
        }

        return movesWanted;
    }

    private ArrayList<Pokemon> getPokemonObjects(ArrayList<String> pkmnNames) {
        ArrayList<Pokemon> pokemonObjects = new ArrayList<>();

        for (int i = 0; i < pkmnNames.size(); i++) {
            String pkmnName = pkmnNames.get(i);
            Pokemon pokemon = request.searchPokemon(pkmnName);
            pokemonObjects.add(pokemon);
        }

        return pokemonObjects;
    }
    
    public void setRequestObject(Request request) {
        this.request = request;
    }

    public void setItemMatch(ItemMatch itemMatch) {
        this.itemMatch = itemMatch;
    }
}
