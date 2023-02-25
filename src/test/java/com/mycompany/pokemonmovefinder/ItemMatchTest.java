package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.NamedAPIResource;
import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.move.Move;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemMatchTest {
    
    public ItemMatchTest() {
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
     * Test of pkmnThatLearnAllMoves method, of class ItemMatch.
     */
    @Test
    public void testPkmnThatLearnAllMoves() {
        System.out.println("testing pkmnThatLearnAllMoves");
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
        
        ItemMatch itemMatch = new ItemMatch();
        ArrayList<String> result = itemMatch.pkmnThatLearnAllMoves(testMoveList);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("bulbasaur");
        expResult.add("squirtle");
        expResult.add("charmander");

        assertEquals(expResult, result);
    }
    
}
