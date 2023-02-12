package com.mycompany.pokemonmovefinder.tools;

import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.SimpleInfo;
import com.mycompany.pokeapilibrary.StringFormatter;
import com.mycompany.pokeapilibrary.move.PagesOfMoves;
import com.mycompany.pokemonmovefinder.MoveSelectData;
import java.util.ArrayList;
import java.util.Collections;

public class MoveSelectDataLoader {

    //this is to get the move names i.e. "Earthquake" and the value i.e "earthquake"
    //this is for use in the drop down options which display "Earthquake" but
    //have the value "earthquake". Capitalised names won't work with the API
    public static ArrayList<MoveSelectData> getArrayListOfMoveSelectDataFromAPI() {
        ArrayList<String> moveNames = getNamesOfAllMovesFromAPI();

        ArrayList<MoveSelectData> arrayList = new ArrayList<>();
        for (int i = 0; i < moveNames.size(); i++) {
            String basicText = moveNames.get(i);
            String displayText = StringFormatter.basicFormat(basicText);

            MoveSelectData newItem = new MoveSelectData(displayText, basicText);
            arrayList.add(newItem);
        }

        return arrayList;
    }

    public static ArrayList<String> getNamesOfAllMovesFromAPI() {
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
