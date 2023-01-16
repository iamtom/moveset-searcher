package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.move.Move;
import com.mycompany.pokeapilibrary.pokemon.Pokemon;
import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.SimpleInfo;
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

public class SearchTest {
    
    public SearchTest() {
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
     * Test of getMovesFromAPI method, of class Search.
     */
    @Test
    public void testGetMovesFromAPI() {
        System.out.println("getMovesFromAPI test");
        
        //set up test input
        MovesInput movesInput = new MovesInput();
        movesInput.setMove1("test1");
        movesInput.setMove2("test2");
        movesInput.setMove3("test3");
        movesInput.setMove4("test4");        
        
        //mock Request object will return testMove every time
        Move testMove = new Move();
        Request mockRequest = mock(Request.class);          
        when(mockRequest.searchMove(anyString())).thenReturn(testMove);  
                
        Search search = new Search(movesInput);       
        search.setRequestObject(mockRequest);
        
        ArrayList<Move> expResult = new ArrayList<>();
        expResult.add(testMove);
        expResult.add(testMove);
        expResult.add(testMove);
        expResult.add(testMove);
        
        ArrayList<Move> result = search.getMovesFromAPI();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getResults method, of class Search.
     */
    @Test
    public void testGetResults() {
        //TODO getResults test
        System.out.println("getResults test");
        Search instance = null;
        ArrayList<Result> expResult = null;
        ArrayList<Result> result = instance.getResults();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of listOfNamesForPkmnThatLearn method, of class Search.
     */
    @Test
    public void testListOfNamesForPkmnThatLearn() {
        System.out.println("listOfNamesForPkmnThatLearn test");
        
        SimpleInfo bulbasaurInfo = new SimpleInfo();
        bulbasaurInfo.setName("bulbasaur");
        SimpleInfo squirtleInfo = new SimpleInfo();
        squirtleInfo.setName("squirtle");
        SimpleInfo charmanderInfo = new SimpleInfo();
        charmanderInfo.setName("charmander");
        
        ArrayList<SimpleInfo> testLearnedByPokemon = new ArrayList<>();
        testLearnedByPokemon.add(bulbasaurInfo);
        testLearnedByPokemon.add(squirtleInfo);
        testLearnedByPokemon.add(charmanderInfo);
        
        Move mockMove = mock(Move.class);
        when(mockMove.learnedByPokemon()).thenReturn(testLearnedByPokemon);

        //set up test input
        MovesInput movesInput = new MovesInput();
        movesInput.setMove1("test1");
        movesInput.setMove2("test2");
        movesInput.setMove3("test3");
        movesInput.setMove4("test4");    
        
        Search search = new Search(movesInput);
                
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("bulbasaur");
        expResult.add("squirtle");
        expResult.add("charmander");
        
        ArrayList<String> result = search.listOfNamesForPkmnThatLearn(mockMove);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void pkmnInAllLists_FourMoves() {
        System.out.println("pkmnInAllLists test with four moves");

        //set up test input
        MovesInput movesInput = new MovesInput();
        movesInput.setMove1("test1");
        movesInput.setMove2("test2");
        movesInput.setMove3("test3");
        movesInput.setMove4("test4");    
        
        Search search = new Search(movesInput);
        
        ArrayList<String> pkmnForMove1 = new ArrayList<>();
        pkmnForMove1.add("bulbasaur");
        pkmnForMove1.add("squirtle");
        pkmnForMove1.add("charmander");
        pkmnForMove1.add("pikachu");
        pkmnForMove1.add("dragonite");
        ArrayList<String> pkmnForMove2 = new ArrayList<>();
        pkmnForMove2.add("bulbasaur");
        pkmnForMove2.add("squirtle");
        pkmnForMove2.add("charmander");
        pkmnForMove2.add("pikachu");
        ArrayList<String> pkmnForMove3 = new ArrayList<>();
        pkmnForMove3.add("bulbasaur");
        pkmnForMove3.add("squirtle");
        pkmnForMove3.add("charmander");
        pkmnForMove3.add("dragonite");
        ArrayList<String> pkmnForMove4 = new ArrayList<>();
        pkmnForMove4.add("bulbasaur");
        pkmnForMove4.add("squirtle");
        pkmnForMove4.add("charmander");
        pkmnForMove4.add("dragonite");
        
        ArrayList<ArrayList<String>> testLists = new ArrayList<>();
        testLists.add(pkmnForMove1);
        testLists.add(pkmnForMove2);
        testLists.add(pkmnForMove3);
        testLists.add(pkmnForMove4);
                
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("bulbasaur");
        expResult.add("squirtle");
        expResult.add("charmander");
        
        ArrayList<String> result = search.pkmnInAllLists(testLists);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void pkmnInAllLists_ThreeMoves() {
        System.out.println("pkmnInAllLists test with three moves");

        //set up test input
        MovesInput movesInput = new MovesInput();
        movesInput.setMove1("test1");
        movesInput.setMove2("test2");
        movesInput.setMove3("test3");
        movesInput.setMove4("");    
        
        Search search = new Search(movesInput);
        
        ArrayList<String> pkmnForMove1 = new ArrayList<>();
        pkmnForMove1.add("bulbasaur");
        pkmnForMove1.add("squirtle");
        pkmnForMove1.add("charmander");
        pkmnForMove1.add("pikachu");
        pkmnForMove1.add("dragonite");
        ArrayList<String> pkmnForMove2 = new ArrayList<>();
        pkmnForMove2.add("bulbasaur");
        pkmnForMove2.add("squirtle");
        pkmnForMove2.add("charmander");
        pkmnForMove2.add("pikachu");
        ArrayList<String> pkmnForMove3 = new ArrayList<>();
        pkmnForMove3.add("bulbasaur");
        pkmnForMove3.add("squirtle");
        pkmnForMove3.add("charmander");
        pkmnForMove3.add("dragonite");
        
        ArrayList<ArrayList<String>> testLists = new ArrayList<>();
        testLists.add(pkmnForMove1);
        testLists.add(pkmnForMove2);
        testLists.add(pkmnForMove3);
                
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("bulbasaur");
        expResult.add("squirtle");
        expResult.add("charmander");
        
        ArrayList<String> result = search.pkmnInAllLists(testLists);
        
        assertEquals(expResult, result);
    }
    
}
