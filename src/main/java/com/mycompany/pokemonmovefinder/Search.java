package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.move.Move;
import java.util.ArrayList;


public class Search {
    private ArrayList<String> moveNames;
    private Request request;
    
    public Search (MovesInput movesInput) {
        this.moveNames = new ArrayList<>();
        this.moveNames = movesInput.asArrayList();
    }
    
    public ArrayList<Move> getMovesFromAPI() {
        this.request = new Request();
        
        ArrayList<Move> moves = new ArrayList<>();
        
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
        
        for(int i = 0; i < moves.size(); i++) {
            Move currentMove = moves.get(i);
            
            for(int j = 0; j < currentMove.learnedByPokemon().size(); j++) {
                String pkmnName = currentMove.learnedByPokemon().get(j).getName();
                if(!uniquePkmnNames.contains(pkmnName)) {
                    uniquePkmnNames.add(pkmnName);
                }
            }
        }
        System.out.println(uniquePkmnNames);
        return uniquePkmnNames;
    }
    
//    public ArrayList<Result> getResults() {
//        //find which pokemon can learn which of the moves
          //create Result objects
//    }
    
}
