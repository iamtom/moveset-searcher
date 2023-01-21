package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.SimpleInfo;
import com.mycompany.pokeapilibrary.move.Move;
import java.util.ArrayList;
import java.util.Collections;


public class Search {
    private ArrayList<String> moveNames;
    private Request request;
    
    public Search (MovesInput movesInput) {
        this.moveNames = new ArrayList<>();
        this.moveNames = movesInput.asArrayList();
        this.request = new Request();
    }
    
    public void setRequestObject(Request request) {
        this.request = request;
    }
    
    public ArrayList<Move> getMovesFromAPI() {
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
    
    public ArrayList<Result> getResults() {        
        //get all the moves first
        ArrayList<Move> moveList = this.getMovesFromAPI();      
        
        //for each move get the names of the pokemon that learn it
        //add those names to an ArrayList called 'names'
        //Add each ArrayList to namesOfPkmnThatLearnEachMove
        ArrayList<ArrayList<String>> namesOfPkmnThatLearnEachMove = new ArrayList<>();
        for (int i = 0; i < moveList.size(); i++) {
            Move currentMove = moveList.get(i);
            ArrayList<String> names = this.listOfNamesForPkmnThatLearn(currentMove);
            namesOfPkmnThatLearnEachMove.add(names);
        }
        
        //now compare lists to find which pokemon can learn all the moves
        ArrayList<String> pkmnThatLearnAllMoves = this.pkmnInAllLists(namesOfPkmnThatLearnEachMove);
        Collections.sort(pkmnThatLearnAllMoves);
        
        //build the list of Result objects
        ArrayList<Result> results = new ArrayList<>(); 
        for(int i = 0; i < pkmnThatLearnAllMoves.size(); i++) {
            String pkmnName = pkmnThatLearnAllMoves.get(i);
            Result result = new Result(pkmnName);
            results.add(result);
        }
        
        return results;
          
    }
    
    public ArrayList<String> listOfNamesForPkmnThatLearn(Move basicMoveInfo) {
        //one ArrayList of pkmn names per move
        ArrayList<String> pkmnThatLearnMove = new ArrayList<>();
        ArrayList<SimpleInfo> learnedByPokemon = basicMoveInfo.learnedByPokemon();
        
        for (int i = 0; i < learnedByPokemon.size(); i++) {
            String name = learnedByPokemon.get(i).getName();
            pkmnThatLearnMove.add(name);
        }     
        
        return pkmnThatLearnMove;
    }
    
    public ArrayList<String> pkmnInAllLists(ArrayList<ArrayList<String>> listOfLists) {
        int noOfLists = listOfLists.size();
        ArrayList<String> firstList = listOfLists.get(0);
        ArrayList<String> pkmnNames = new ArrayList<>();
        
        //work through first list, if the pokemon name is in all the other lists
        //then we know it can learn all the moves
        for(int i = 0; i < firstList.size(); i++) {
            String currentPkmnName = firstList.get(i);
            
            //if reaches 4 add name to pkmnNames 
            int inLists = 1;           
            
            //compare each item in firstList against currentList
            for(int j = 1; j < listOfLists.size(); j++) {
                if(listOfLists.get(j).contains(currentPkmnName)) {
                    inLists++;
                }                
            }
            
            if(inLists == noOfLists) {
                pkmnNames.add(currentPkmnName);
            }
            
        }
        
        return pkmnNames;
    }   
}
