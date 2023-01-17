package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.move.Move;
import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.SimpleInfo;
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
        
        //set up test input
        MovesInput movesInput = new MovesInput();
        movesInput.setMove1("test1");
        movesInput.setMove2("test2");
        movesInput.setMove3("test3");
        movesInput.setMove4("test4");
        
        //create fake moves with set data
        SimpleInfo bulbasaurInfo = new SimpleInfo();
        bulbasaurInfo.setName("bulbasaur");
        SimpleInfo squirtleInfo = new SimpleInfo();
        squirtleInfo.setName("squirtle");
        SimpleInfo charmanderInfo = new SimpleInfo();
        charmanderInfo.setName("charmander");
        SimpleInfo pikachuInfo = new SimpleInfo();
        pikachuInfo.setName("pikachu");
        SimpleInfo dragoniteInfo = new SimpleInfo();
        dragoniteInfo.setName("dragonite");
        
        ArrayList<SimpleInfo> testMove1LearnedByPokemon = new ArrayList<>();
        testMove1LearnedByPokemon.add(bulbasaurInfo);
        testMove1LearnedByPokemon.add(squirtleInfo);
        testMove1LearnedByPokemon.add(charmanderInfo);
        
        ArrayList<SimpleInfo> testMove2LearnedByPokemon = new ArrayList<>();
        testMove2LearnedByPokemon.add(bulbasaurInfo);
        testMove2LearnedByPokemon.add(squirtleInfo);
        testMove2LearnedByPokemon.add(charmanderInfo);
        testMove2LearnedByPokemon.add(pikachuInfo);
        
        ArrayList<SimpleInfo> testMove3LearnedByPokemon = new ArrayList<>();
        testMove3LearnedByPokemon.add(bulbasaurInfo);
        testMove3LearnedByPokemon.add(squirtleInfo);
        testMove3LearnedByPokemon.add(charmanderInfo);
        testMove3LearnedByPokemon.add(dragoniteInfo);
        
        ArrayList<SimpleInfo> testMove4LearnedByPokemon = new ArrayList<>();
        testMove4LearnedByPokemon.add(bulbasaurInfo);
        testMove4LearnedByPokemon.add(squirtleInfo);
        testMove4LearnedByPokemon.add(charmanderInfo);
        testMove4LearnedByPokemon.add(dragoniteInfo);
        
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
        
        //System.out.println("Test move list: " + testMoveList);      

        Search search = new Search(movesInput);
        
        //getResults calls getMovesFromAPI
        //when getMovesFromAPI uses a Request to get moves the mock will return
        //the test moves
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
