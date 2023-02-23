package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.move.Move;
import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.NamedAPIResource;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MoveSearchTest {

    public MoveSearchTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getResults method, of class MoveSearch.
     */
    @Test
    public void testGetResults() {
        System.out.println("getResults test");

        //set up test input
        MovesInput movesInput = new MovesInput();
        movesInput.setMove1("test1");
        movesInput.setMove2("test2");
        movesInput.setMove3("test3");
        movesInput.setMove4("test4");

        //create fake moves with set data
        //first create fake NamedAPIResource with just Pokemon names
        NamedAPIResource bulbasaurInfo = new NamedAPIResource();
        bulbasaurInfo.setName("bulbasaur");
        NamedAPIResource squirtleInfo = new NamedAPIResource();
        squirtleInfo.setName("squirtle");
        NamedAPIResource charmanderInfo = new NamedAPIResource();
        charmanderInfo.setName("charmander");
        NamedAPIResource pikachuInfo = new NamedAPIResource();
        pikachuInfo.setName("pikachu");
        NamedAPIResource dragoniteInfo = new NamedAPIResource();
        dragoniteInfo.setName("dragonite");

        //add those to ArrayLists. These basically represent lists of Pokemon 
        //that learn each test move
        ArrayList<NamedAPIResource> testMove1LearnedByPokemon = new ArrayList<>();
        testMove1LearnedByPokemon.add(bulbasaurInfo);
        testMove1LearnedByPokemon.add(squirtleInfo);
        testMove1LearnedByPokemon.add(charmanderInfo);
        
        ArrayList<NamedAPIResource> testMove2LearnedByPokemon = new ArrayList<>();
        testMove2LearnedByPokemon.add(bulbasaurInfo);
        testMove2LearnedByPokemon.add(squirtleInfo);
        testMove2LearnedByPokemon.add(charmanderInfo);
        testMove2LearnedByPokemon.add(pikachuInfo);

        ArrayList<NamedAPIResource> testMove3LearnedByPokemon = new ArrayList<>();
        testMove3LearnedByPokemon.add(bulbasaurInfo);
        testMove3LearnedByPokemon.add(squirtleInfo);
        testMove3LearnedByPokemon.add(charmanderInfo);
        testMove3LearnedByPokemon.add(dragoniteInfo);

        ArrayList<NamedAPIResource> testMove4LearnedByPokemon = new ArrayList<>();
        testMove4LearnedByPokemon.add(bulbasaurInfo);
        testMove4LearnedByPokemon.add(squirtleInfo);
        testMove4LearnedByPokemon.add(charmanderInfo);
        testMove4LearnedByPokemon.add(dragoniteInfo);
        
        //create fake Moves and add the fake lists of pokemon that learn them
        Move testMove1 = new Move();
        testMove1.setLearnedByPokemon(testMove1LearnedByPokemon);
        Move testMove2 = new Move();
        testMove2.setLearnedByPokemon(testMove2LearnedByPokemon);
        Move testMove3 = new Move();
        testMove3.setLearnedByPokemon(testMove3LearnedByPokemon);
        Move testMove4 = new Move();
        testMove4.setLearnedByPokemon(testMove4LearnedByPokemon);
        
        
        ArrayList<Move> testMoveList = new ArrayList<>();
        testMoveList.add(testMove1);
        testMoveList.add(testMove2);
        testMoveList.add(testMove3);
        testMoveList.add(testMove4);
        //fake moves set-up complete    

        MoveSearch search = new MoveSearch(movesInput);

        //getResults calls getMovesFromAPI
        //when getMovesFromAPI uses a Request to get moves the mock will return
        //the test moves
        
        //this needs to change. cant access searchMove now it is in a private method
        Request mockRequest = mock(Request.class);
        when(mockRequest.searchMove(anyString()))
                .thenReturn(testMove1)
                .thenReturn(testMove2)
                .thenReturn(testMove3)
                .thenReturn(testMove4);
        search.setRequestObject(mockRequest);


        Result result1 = new Result("bulbasaur");
        Result result2 = new Result("charmander");
        Result result3 = new Result("squirtle");
        ArrayList<Result> expResult = new ArrayList<>();
        expResult.add(result1);
        expResult.add(result2);
        expResult.add(result3);

        ArrayList<Result> result = search.getResults();

        assertThat(result).usingRecursiveComparison().isEqualTo(expResult);

    }
    
}
