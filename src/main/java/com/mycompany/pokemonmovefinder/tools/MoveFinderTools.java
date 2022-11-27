package com.mycompany.pokemonmovefinder.tools;

import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.SimpleInfo;
import com.mycompany.pokeapilibrary.StringFormatter;
import com.mycompany.pokeapilibrary.move.PagesOfMoves;
import com.mycompany.pokemonmovefinder.MoveData;
import java.util.ArrayList;

public class MoveFinderTools {
    
    public static void updateMoveDataToDB() {
  
    }
    
    public static ArrayList<MoveData> getArrayListOfMoveDataFromAPI() {
        Request request = new Request();
        PagesOfMoves moves = request.allMoves(0, 844);
        ArrayList<SimpleInfo> results = moves.getResults();       
        ArrayList<MoveData> arrayList = new ArrayList<>();        
        for (int i = 0; i < results.size(); i++) {
            String value = results.get(i).getName();
            String text = StringFormatter.basicFormat(value);
            
            MoveData newItem = new MoveData(text, value);
            arrayList.add(newItem);
        }
        
        return arrayList;
    }
    
}
