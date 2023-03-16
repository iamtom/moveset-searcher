package com.mycompany.movesetsearcher.tools;

import com.mycompany.pokeapilibrary.NamedAPIResource;
import com.mycompany.pokeapilibrary.NamedAPIResourceList;
import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.StringFormatter;
import com.mycompany.movesetsearcher.MoveSelectData;
import java.util.ArrayList;
import java.util.Comparator;

public class MoveSelectDataLoader {

    //this is to get the move names i.e. "Earthquake" and the value i.e "earthquake"
    //this is for use in the drop down options which display "Earthquake" but
    //have the value "earthquake". Capitalised names won't work with the API
    public static ArrayList<MoveSelectData> loadFromAPI() {
        long start = System.nanoTime();

        Request request = new Request();
        NamedAPIResourceList pagesOfMoves = request.allMovesList(0, 918);
        ArrayList<NamedAPIResource> moves = pagesOfMoves.getResults();

        ArrayList<MoveSelectData> moveSelectDataList = new ArrayList<MoveSelectData>();

        for (int i = 0; i < moves.size(); i++) {
            NamedAPIResource move = moves.get(i);

            MoveSelectData moveSelectData = new MoveSelectData(
                    StringFormatter.basicFormat(move.getName()),
                    move.getName());

            moveSelectDataList.add(moveSelectData);
        }

        //sort moveSelectList by the basicText property of each object
        moveSelectDataList.sort(Comparator.comparing(a -> a.getBasicText()));

        long end = System.nanoTime();
        double durationInMilliseconds = 1.0 * (end - start) / 1000000;
        System.out.println("loadFromAPI took "
                + durationInMilliseconds + " ms.");

        return moveSelectDataList;
    }

}
