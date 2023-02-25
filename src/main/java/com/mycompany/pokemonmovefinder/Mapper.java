package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.move.Move;
import java.util.ArrayList;

public class Mapper {
    
    private Request request;
    
    public ArrayList<Move> toMoveList(MovesInputDTO movesInput) {
        this.request = new Request();
        
        ArrayList<String> moveNames = new ArrayList<>();
        
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
        
        ArrayList<Move> moveList = new ArrayList<>();

        //search each move name in the API
        //add resulting Move object to moves ArrayList
        for (int i = 0; i < moveNames.size(); i++) {
            String searchFor = moveNames.get(i);
            Move move = this.request.searchMove(searchFor);
            moveList.add(move);
        }
        
        return moveList;
    }
}
