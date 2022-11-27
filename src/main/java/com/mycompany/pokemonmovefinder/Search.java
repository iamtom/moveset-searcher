package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.SimpleInfo;
import com.mycompany.pokeapilibrary.move.Move;
import com.mycompany.pokeapilibrary.pokemon.Pokemon;
import java.util.ArrayList;


public class Search {
    private ArrayList<String> moveNames;
    private Request request;
    
    public Search (MovesInput movesInput) {
        this.moveNames = new ArrayList<>();
        this.moveNames = movesInput.asArrayList();
        this.request = new Request();
    }
    
    public ArrayList<Move> getMovesFromAPI() {
        //this.request = new Request();
        
        ArrayList<Move> moves = new ArrayList<>();
        
        //search each move name in the API
        //add resulting Move object to moves ArrayList
        for(int i = 0; i < this.moveNames.size(); i++) {
            String searchFor = this.moveNames.get(i);
            Move move = this.request.searchMove(searchFor);
            moves.add(move);
        }
        
        return moves;
    }
    
    public ArrayList<String> getUniquePkmnNames() {
        ArrayList<Move> moves = getMovesFromAPI();
        ArrayList<String> uniquePkmnNames = new ArrayList<>();
        
        //for each move get the name of the move then add names
        //of all the pokemon that can learn it if uniquePkmnNames does not
        //already contain that name
        for(int i = 0; i < moves.size(); i++) {
            Move currentMove = moves.get(i);
            
            for(int j = 0; j < currentMove.learnedByPokemon().size(); j++) {
                String pkmnName = currentMove.learnedByPokemon().get(j).getName();
                if(!uniquePkmnNames.contains(pkmnName)) {
                    uniquePkmnNames.add(pkmnName);
                }
            }
        }
        //System.out.println(uniquePkmnNames);
        return uniquePkmnNames;
    }
    
    public ArrayList<String> getUniquePkmnURLs() {
        ArrayList<Move> moves = getMovesFromAPI();
        ArrayList<String> uniquePkmnURLs = new ArrayList<>();
        
        //for each move get the name of the move then add URLs
        //of all the pokemon that can learn it if uniquePkmnURLs does not
        //already contain that URL
        for(int i = 0; i < moves.size(); i++) {
            Move currentMove = moves.get(i);
            
            for(int j = 0; j < currentMove.learnedByPokemon().size(); j++) {
                String pkmnURL = currentMove.learnedByPokemon().get(j).getUrl();
                if(!uniquePkmnURLs.contains(pkmnURL)) {
                    uniquePkmnURLs.add(pkmnURL);
                }
            }
        }
        //System.out.println(uniquePkmnURLs);
        return uniquePkmnURLs;
    }
    
    public ArrayList<Pokemon> createPokemonObjects() {
        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        ArrayList<String> pkmnNames = this.getUniquePkmnNames();
        
        for(int i = 0; i < pkmnNames.size(); i++) {
            Pokemon pokemon = request.searchPokemon(pkmnNames.get(i));
            pokemonList.add(pokemon);
        }
        System.out.println(pokemonList);
        return pokemonList;
    }
    
    public ArrayList<Result> getResults() {
        ArrayList<Result> results = new ArrayList<>();
        //find which pokemon can learn which of the moves
        //ArrayList<Pokemon> pokemonList = createPokemonObjects();
        ArrayList<Move> basicMoveInfo = this.getMovesFromAPI();
        ArrayList<ArrayList<String>> pkmnThatLearnEachMove = new ArrayList<>();
        
        //for each move get the names of the pokemon that learn it and add
        //to the names ArrayList. Add each ArrayList to pkmnThatLearnEachMove
        for (int i = 0; i < basicMoveInfo.size(); i++) {
            Move currentMove = basicMoveInfo.get(i);
            ArrayList<String> names = this.listOfPkmnThatLearn(currentMove);
            pkmnThatLearnEachMove.add(names);
        }
        
        //now compare lists to find which pokemon can learn all the moves
        ArrayList<String> pkmnThatLearnAllMoves = this.pkmnInAllLists(pkmnThatLearnEachMove);
        
        return results;
          
    }

    private ArrayList<String> listOfPkmnThatLearn(Move basicMoveInfo) {
        //one ArrayList of pkmn names per move
        ArrayList<String> pkmnThatLearnMove = new ArrayList<>();
        ArrayList<SimpleInfo> learnedByPokemon = basicMoveInfo.learnedByPokemon();
        
        for (int i = 0; i < learnedByPokemon.size(); i++) {
            String name = learnedByPokemon.get(i).getName();
            pkmnThatLearnMove.add(name);
        }     
        
        return pkmnThatLearnMove;
    }
    
    private ArrayList<String> pkmnInAllLists(ArrayList<ArrayList<String>> listOfLists) {
        //work through first list, if the pokemon name is in all the other lists
        //then we know it can learn all the moves
        ArrayList<String> firstList = listOfLists.get(0);
        for(int i = 0; i < firstList.size(); i++) {
            //TODO see if each name occurs in all the other lists
            //if so add to list of pkmn
        }
        
    }
    
}
