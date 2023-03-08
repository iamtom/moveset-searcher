package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.StringFormatter;
import com.mycompany.pokeapilibrary.pokemon.PokemonMove;
import com.mycompany.pokeapilibrary.pokemon.PokemonMoveVersion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private String pkmnName;
    //private ArrayList<PokemonMove> moves;
    //key is version name, value is data for moves in that version
    private HashMap<String, ArrayList<ResultMoveData>> resultMoveDataList;
    //remember level learned at 0 is when it is learned some way other than level up
    //TODO add moves and versions etc so that the user can see which versions
    //the pokemon learns some or all of the moves in

    public Result(String pkmnName) {
        this.pkmnName = StringFormatter.basicFormat(pkmnName);
    }    
    
//    public Result(String pkmnName, ArrayList<PokemonMove> moves) {
//        this.pkmnName = StringFormatter.basicFormat(pkmnName);
//        this.moves = moves;
//    }
    
    public static Result createResult(String pkmnName, ArrayList<PokemonMove> moves) {
        Result result = new Result(pkmnName);
        //get all version names
        //for each version:
        //get move name
        //get version
        //within version get learnmethods and levels learned
        //create ResultMoveData
        HashMap<String, ResultMoveData> resultMoveDataMap = new HashMap<>();
        
        //finding all the version names so they can be compared to later
//        ArrayList<String> versionNames = new ArrayList<>();
//        for (PokemonMove move : moves) {
//            ArrayList<PokemonMoveVersion> versions = move.getVersionGroupDetails();
//            for (PokemonMoveVersion version : versions) {
//                String versionName = version.getVersionGroup().getName();
//                if(versionNames.contains(versionName)) {
//                   continue; 
//                }
//                versionNames.add(versionName);
//            }
//        }
               
        int count = 0;
        //Go through each move one at a time
        //get name
        //
        while(count < moves.size()) {
            PokemonMove currentMove = moves.get(count);
            String moveName = currentMove.getMove().getName();
            
            ArrayList<String> versionNames = new ArrayList<>();
            ArrayList<PokemonMoveVersion> versions = currentMove.getVersionGroupDetails();
            for (PokemonMoveVersion version : versions) {
                String versionName = version.getVersionGroup().getName();
                if(versionNames.contains(versionName)) {
                   continue; 
                }
                versionNames.add(versionName);
            }
            
            for(String versionName : versionNames) {
                //e.g. use Stream to get all PokemonMoveVersion 
                //where versionGroup.getName() = versionName
                List<PokemonMoveVersion> forThisVersion = new ArrayList<>();
                forThisVersion = versions
                        .stream()
                        .filter(v -> v.getVersionGroup().getName().equals(versionName))
                        .collect(Collectors.toList());
                
                //now for each PokemonMoveVersion get the version name for the key
                //and make the ResultMoveData object. Add to HashMap
                
            }   
            

            
            ArrayList<ResultMoveData> resultMoveDataList = new ArrayList<>();
            
            //get all the version names for the current move
//            ArrayList<String> versionNames = new ArrayList<>(); 
//            for(PokemonMoveVersion version : currentMove.getVersionGroupDetails()) {
//                String versionName = version.getVersionGroup().getName();
//                if(!versionNames.contains(versionName)) {
//                    versionNames.add(versionName);
//                }
//            }
            
            
            
            //go through each version name, gather information for the move
            
//            ArrayList<PokemonMoveVersion> versionNames = currentMove.getVersionGroupDetails()
//                    .stream()
//                    .filter(v -> v.getVersionGroup().getName())
//                    .

            
            //String versionName;
            HashMap<String, String> learnMethods = new HashMap<>();

            for (PokemonMove move : moves) {
                
            }
            
        }

        return result;
    }

    public String getPkmnName() {
        return pkmnName;
    }

    public void setPkmnName(String pkmnName) {
        this.pkmnName = pkmnName;
    }

//    public ArrayList<PokemonMove> getMoves() {
//        return moves;
//    }
//
//    public void setMoves(ArrayList<PokemonMove> moves) {
//        this.moves = moves;
//    }

    public ArrayList<ResultMoveData> getResultMoveDataList() {
        return resultMoveDataList;
    }

    public void setResultMoveDataList(ArrayList<ResultMoveData> resultMoveDataList) {
        this.resultMoveDataList = resultMoveDataList;
    }

    @Override
    public String toString() {
        return "Result{" + "pkmnName=" + pkmnName + ", moves=" + moves + ", moveResults=" + moveResults + '}';
    }
}
