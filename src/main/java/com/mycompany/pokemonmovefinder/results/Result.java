package com.mycompany.pokemonmovefinder.results;

import com.mycompany.pokeapilibrary.StringFormatter;
import com.mycompany.pokeapilibrary.pokemon.PokemonMove;
import com.mycompany.pokeapilibrary.pokemon.PokemonMoveVersion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private String pkmnName;
    private ArrayList<PokemonVersionResultData> versionResultDataList;
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
    public static Result createResultGroupedByVersion(String pkmnName, ArrayList<PokemonMove> moves) {
        Result result = new Result(pkmnName);
        //get all version names
        //for each version:
        //get move name
        //get version
        //within version get learnmethods and levels learned
        //create PokemonMoveResultData

        //pkmnName is set
        //get each move
        //in each move get all the version names
        //for each version name get all the versionGroup where the name is versionName
        //Go through each one, create hashmap of learnmethods and get move name
        //create PokemonMoveResultData add to list
        //then create versionResultDataList
        //
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

        ArrayList<PokemonVersionResultData> versionResultDataList = new ArrayList<>();
        
        int count = 0;
        while (count < moves.size()) {
            PokemonMove currentMove = moves.get(count);
            String currentMoveName = currentMove.getMove().getName();
            //list of all versionGroupDetails for this move
            //this has the version, learn method, and level learned
            //need to break it into separate lists based on version names
            //there is one of these per version
            //go through each one, take the data out into a HashMap
            //where key is version name and value is a PokemonMoveResultData with the info in it
            //HashMap<String, ArrayList<ResultMoveData>> resultMoveDataList
            //String versionName, ArrayList<ResultMoveData>
            ArrayList<PokemonMoveVersion> versions = currentMove.getVersionGroupDetails();
            
            ArrayList<PokemonMoveResultData> pokemonMoveResultDataList = new ArrayList<>();


            //get a list of all the version names associated with this move
            ArrayList<String> versionNames = new ArrayList<>();
            for (PokemonMoveVersion version : versions) {
                String versionName = version.getVersionGroup().getName();
                if (versionNames.contains(versionName)) {
                    continue;
                }
                versionNames.add(versionName);
            }

            for (String versionName : versionNames) {
                //e.g. use Stream to get all PokemonMoveVersion 
                //where versionGroup.getName() = versionName
                List<PokemonMoveVersion> groupedByVersion = new ArrayList<>();
                groupedByVersion = versions
                        .stream()
                        .filter(v -> v.getVersionGroup().getName().equals(versionName))
                        .collect(Collectors.toList());
                
                //get the learnmethods for the move in this version
                HashMap<String, String> learnMethods = new HashMap<>();
                for (PokemonMoveVersion version : groupedByVersion) {
                    //getting out of memory error here:
                    learnMethods.put(version.getMoveLearnMethod().getName(),
                            String.valueOf(version.getLevelLearnedAt()));
                }
                
                PokemonMoveResultData pkmnMoveResData = new PokemonMoveResultData(currentMoveName, learnMethods);
                pokemonMoveResultDataList.add(pkmnMoveResData);
                PokemonVersionResultData pkmnVerResData = new PokemonVersionResultData(versionName, pokemonMoveResultDataList);
                versionResultDataList.add(pkmnVerResData);
                
                //now for each PokemonMoveVersion get the version name for the key
                //and make the PokemonMoveResultData object. Add to HashMap

            }

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
        }
        
        result.setVersionResultDataList(versionResultDataList);
        
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
    public ArrayList<PokemonVersionResultData> getVersionResultDataList() {
        return versionResultDataList;
    }

    public void setVersionResultDataList(ArrayList<PokemonVersionResultData> versionResultDataList) {
        this.versionResultDataList = versionResultDataList;
    }

    @Override
    public String toString() {
        return "Result{" + "pkmnName=" + pkmnName + ", versionResultDataList=" + versionResultDataList + '}';
    }
}
