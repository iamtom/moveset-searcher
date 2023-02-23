package com.mycompany.pokemonmovefinder;

public class MovesInputDTO {

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

}
