package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.NamedAPIResource;
import com.mycompany.pokeapilibrary.move.Move;
import java.util.ArrayList;


public class ItemMatch {
    
    public ItemMatch() {
        
    }
    
    public ArrayList<String> pkmnThatLearnAllMoves(ArrayList<Move> moveList) {
        ArrayList<ArrayList<String>> listsOfPkmnThatLearnEachMove = 
                                    this.listsOfPkmnThatLearnEachMove(moveList);
        
        ArrayList<String> pkmnThatLearnAllMoves = 
                            this.pkmnInAllLists(listsOfPkmnThatLearnEachMove);
        
        return pkmnThatLearnAllMoves;
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

    private ArrayList<String> listOfNamesForPkmnThatLearn(Move move) {
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

            //if reaches same as noOfLists add name to pkmnNames 
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
}
