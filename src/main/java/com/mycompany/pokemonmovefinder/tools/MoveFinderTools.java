package com.mycompany.pokemonmovefinder.tools;

import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.SimpleInfo;
import com.mycompany.pokeapilibrary.move.Moves;
import java.util.ArrayList;

public class MoveFinderTools {
    
    public static void updateMoveDataToDB() {
        Request request = new Request();
        Moves moves = request.allMoves(0, 844);
        
        ArrayList<SimpleInfo> results = moves.getResults();
        
//        ArrayList<String> moveNames = new ArrayList<String>();
//        for (int i = 0; i < moveNames.size(); i++) {
//            String name = results.get(i).getName();
//            moveNames.add(name);
//        }

        
        
        
    }
    
}
