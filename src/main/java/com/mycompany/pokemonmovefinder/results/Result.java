package com.mycompany.pokemonmovefinder.results;

import com.mycompany.pokeapilibrary.StringFormatter;
import com.mycompany.pokeapilibrary.pokemon.PokemonMove;
import com.mycompany.pokeapilibrary.pokemon.PokemonMoveVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private String pkmnName;
    private LinkedHashMap<String, List<MoveResultData>> moveResultData;

    public Result(String pkmnName, LinkedHashMap<String, List<MoveResultData>> moveResultData) {
        this.pkmnName = StringFormatter.basicFormat(pkmnName);
        this.moveResultData = moveResultData;
    }

    public static Result createResultGroupedByVersion(String pkmnName, ArrayList<PokemonMove> moves) {
        LinkedHashMap<String, List<MoveResultData>> versionResultData = new LinkedHashMap<>();

        ArrayList<String> allVersionNames = new ArrayList<>();
        allVersionNames = Result.allVersionNames(moves);
        Collections.sort(allVersionNames);

        for (String currentVersion : allVersionNames) {
            List<MoveResultData> moveResultDataList = new ArrayList<>();
            for (PokemonMove move : moves) {
                String moveName = move.getMove().getName();
                ArrayList<PokemonMoveVersion> versionGroupDetails = move.getVersionGroupDetails();
                List<PokemonMoveVersion> dataForCurrentVersion = Result.groupedByVersion(currentVersion, versionGroupDetails);
                ArrayList<String> learnMethods = Result.extractLearnMethods(dataForCurrentVersion);
                MoveResultData moveResultData = new MoveResultData(moveName, learnMethods);
                moveResultDataList.add(moveResultData);
            }
            //moveResultDataList.sort(Comparator.comparing(o -> o.getMoveName()));
            String versionName = StringFormatter.formatVersionName(currentVersion);
            versionResultData.put(versionName, moveResultDataList);
        }

        Result result = new Result(pkmnName, versionResultData);

        return result;

    }

    private static ArrayList<String> allVersionNames(ArrayList<PokemonMove> moves) {
        ArrayList<String> allVersionNames = new ArrayList<>();
        for (PokemonMove move : moves) {
            ArrayList<PokemonMoveVersion> versions = move.getVersionGroupDetails();
            for (PokemonMoveVersion version : versions) {
                String versionName = version.getVersionGroup().getName();
                if (!allVersionNames.contains(versionName)) {
                    allVersionNames.add(versionName);
                }

            }
        }

        return allVersionNames;
    }

    private static List<PokemonMoveVersion> groupedByVersion(String versionName, ArrayList<PokemonMoveVersion> versionGroupDetails) {
        List<PokemonMoveVersion> groupedByVersion = versionGroupDetails
                .stream()
                .filter(v -> v.getVersionGroup().getName().equals(versionName))
                .collect(Collectors.toList());

        return groupedByVersion;
    }

    private static ArrayList<String> extractLearnMethods(List<PokemonMoveVersion> dataForCurrentVersion) {
        ArrayList<String> learnMethods = new ArrayList<>();

        for (PokemonMoveVersion version : dataForCurrentVersion) {
            String learnMethod = version.getMoveLearnMethod().getName();
            int levelLearnedAt = version.getLevelLearnedAt();

            if (learnMethod.equals("level-up")) {
                learnMethod = "Level " + levelLearnedAt;
            }
            learnMethod = StringFormatter.basicFormat(learnMethod);
            learnMethods.add(learnMethod);

        }
        return learnMethods;
    }

    public String getPkmnName() {
        return pkmnName;
    }

    public void setPkmnName(String pkmnName) {
        this.pkmnName = pkmnName;
    }

    public LinkedHashMap<String, List<MoveResultData>> getMoveResultData() {
        return moveResultData;
    }

    public void setMoveResultData(LinkedHashMap<String, List<MoveResultData>> moveResultData) {
        this.moveResultData = moveResultData;
    }

    @Override
    public String toString() {
        return "Result{" + "pkmnName=" + pkmnName + ", versionResultData=" + moveResultData + '}';
    }

}
