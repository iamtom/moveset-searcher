package com.mycompany.pokemonmovefinder.tools;

import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.SimpleInfo;
import com.mycompany.pokeapilibrary.StringFormatter;
import com.mycompany.pokeapilibrary.move.PagesOfMoves;
import com.mycompany.pokemonmovefinder.MoveData;
import java.util.ArrayList;
import java.util.Collections;

public class MoveFinderTools {
    
    public static void updateMoveDataToDB() {
  
    }
    
    public static ArrayList<MoveData> getArrayListOfMoveDataFromAPI() {
        ArrayList<String> moveNames = getMoveNamesFromAPI();
        
        ArrayList<MoveData> arrayList = new ArrayList<>();        
        for (int i = 0; i < moveNames.size(); i++) {
            String value = moveNames.get(i);
            String text = StringFormatter.basicFormat(value);
            
            MoveData newItem = new MoveData(text, value);
            arrayList.add(newItem);
        }
            
        return arrayList;
    }
    
    public static ArrayList<String> getMoveNamesFromAPI() {
        Request request = new Request();
        PagesOfMoves moves = request.allMoves(0, 844);
        ArrayList<SimpleInfo> results = moves.getResults();
        
        //make list of names for sorting into alphabetical order
        ArrayList<String> moveNames = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            moveNames.add(results.get(i).getName());
        }
        Collections.sort(moveNames);
        
        return moveNames;
    }
        
}
