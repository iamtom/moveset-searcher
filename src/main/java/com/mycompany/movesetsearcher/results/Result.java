package com.mycompany.movesetsearcher.results;

import com.mycompany.pokeapilibrary.StringFormatter;
import java.util.LinkedHashMap;
import java.util.List;

public class Result {

    private String pkmnName;
    private LinkedHashMap<String, List<MoveResultData>> moveResultData;

    public Result(String pkmnName, LinkedHashMap<String, List<MoveResultData>> moveResultData) {
        this.pkmnName = StringFormatter.basicFormat(pkmnName);
        this.moveResultData = moveResultData;
    }

    public Result() {
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
