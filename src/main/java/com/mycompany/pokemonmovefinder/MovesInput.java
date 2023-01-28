
package com.mycompany.pokemonmovefinder;

import java.util.ArrayList;

public class MovesInput {
    
    @ValidateMovesInput
    private String move1;
    @ValidateMovesInput
    private String move2;
    @ValidateMovesInput
    private String move3;
    @ValidateMovesInput
    private String move4;

    public String getMove1() {
        return move1;
    }

    public void setMove1(String move1) {
        this.move1 = move1;
    }

    public String getMove2() {
        return move2;
    }

    public void setMove2(String move2) {
        this.move2 = move2;
    }

    public String getMove3() {
        return move3;
    }

    public void setMove3(String move3) {
        this.move3 = move3;
    }

    public String getMove4() {
        return move4;
    }

    public void setMove4(String move4) {
        this.move4 = move4;
    }
    
    public ArrayList<String> asArrayList() {
        ArrayList<String> arrayList = new ArrayList();
        
        if(!this.move1.equals("")) {
            arrayList.add(move1);
        }
        if(!this.move2.equals("")) {
            arrayList.add(move2);
        }
        if(!this.move3.equals("")) {
            arrayList.add(move3);
        }
        if(!this.move4.equals("")) {
            arrayList.add(move4);
        }     
                
        return arrayList;
    }
    
}
