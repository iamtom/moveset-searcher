package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.NamedAPIResource;
import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.move.Move;
import com.mycompany.pokeapilibrary.pokemon.Pokemon;
import com.mycompany.pokeapilibrary.pokemon.PokemonMove;
import java.util.ArrayList;
import java.util.Collections;

public class MoveSearch implements Searcher {

    private final ArrayList<String> moveNames;
    private Request request;

    public MoveSearch(MovesInput movesInput) {
        this.moveNames = new ArrayList<>();

        if (!movesInput.getMove1().equals("")) {
            moveNames.add(movesInput.getMove1());
        }
        if (!movesInput.getMove2().equals("")) {
            moveNames.add(movesInput.getMove2());
        }
        if (!movesInput.getMove3().equals("")) {
            moveNames.add(movesInput.getMove3());
        }
        if (!movesInput.getMove4().equals("")) {
            moveNames.add(movesInput.getMove4());
        }

        this.request = new Request();
    }

    public void setRequestObject(Request request) {
        this.request = request;
    }

    public ArrayList<Result> getResults() {
        //get all the moves first
        ArrayList<Move> moveList = this.getMovesFromAPI();

        ArrayList<ArrayList<String>> listsOfPkmnThatLearnEachMove = this.listsOfPkmnThatLearnEachMove(moveList);       

        //now compare lists to find which pokemon can learn all the moves
        ArrayList<String> pkmnThatLearnAllMoves = this.pkmnInAllLists(listsOfPkmnThatLearnEachMove);
        Collections.sort(pkmnThatLearnAllMoves);

        ArrayList<Pokemon> pokemonObjects = this.getPokemonObjects(pkmnThatLearnAllMoves);
        
        ArrayList<Result> results = new ArrayList<>();       
        for (Pokemon pokemon : pokemonObjects) {
            ArrayList<PokemonMove> moves = getPokemonMoves(pokemon);
            Result result = new Result(pokemon.getName(), moves);
            results.add(result);  
        }
        
        //System.out.println(results);
        return results;

    }
    
    private ArrayList<Move> getMovesFromAPI() {
        ArrayList<Move> moves = new ArrayList<>();

        //search each move name in the API
        //add resulting Move object to moves ArrayList
        for (int i = 0; i < this.moveNames.size(); i++) {
            String searchFor = this.moveNames.get(i);
            Move move = this.request.searchMove(searchFor);
            moves.add(move);
        }

        return moves;
    }    
    
    private ArrayList<ArrayList<String>> listsOfPkmnThatLearnEachMove(ArrayList<Move> moveList) {
        //for each move get the names of the pokemon that learn it
        //add those names to an ArrayList called 'names'
        //Add each ArrayList to listsOfPkmnThatLearnEachMove

        ArrayList<ArrayList<String>> namesOfPkmnThatLearnEachMove = new ArrayList<>();
        
        for (int i = 0; i < moveList.size(); i++) {
            Move currentMove = moveList.get(i);
            ArrayList<String> names = this.listOfNamesForPkmnThatLearn(currentMove);
            namesOfPkmnThatLearnEachMove.add(names);
        }
        
        return namesOfPkmnThatLearnEachMove;
    }

    private ArrayList<PokemonMove> getPokemonMoves(Pokemon pokemon) {
        //lets try a hashmap since we know what moves we want
        //key move.getName? and value PokemonMove move
        
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

    private ArrayList<String> listOfNamesForPkmnThatLearn(Move move) {
        //one ArrayList of pkmn names per move
        ArrayList<String> pkmnThatLearnMove = new ArrayList<>();
        ArrayList<NamedAPIResource> learnedByPokemon = move.learnedByPokemon();

        for (int i = 0; i < learnedByPokemon.size(); i++) {
            String name = learnedByPokemon.get(i).getName();
            pkmnThatLearnMove.add(name);
        }

        return pkmnThatLearnMove;
    }

    private ArrayList<String> pkmnInAllLists(ArrayList<ArrayList<String>> listOfLists) {
        int noOfLists = listOfLists.size();
        ArrayList<String> firstList = listOfLists.get(0);
        ArrayList<String> pkmnNames = new ArrayList<>();

        //work through first list, if the pokemon name is in all the other lists
        //then we know it can learn all the moves
        for (int i = 0; i < firstList.size(); i++) {
            String currentPkmnName = firstList.get(i);

            //if reaches 4 add name to pkmnNames 
            int inLists = 1;

            //compare each item in firstList against currentList
            for (int j = 1; j < listOfLists.size(); j++) {
                if (listOfLists.get(j).contains(currentPkmnName)) {
                    inLists++;
                }
            }

            if (inLists == noOfLists) {
                pkmnNames.add(currentPkmnName);
            }

        }

        return pkmnNames;
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
}
