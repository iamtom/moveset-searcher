package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.move.Move;
import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.NamedAPIResource;
import com.mycompany.pokeapilibrary.pokemon.Pokemon;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokemonSearchTest {

    public PokemonSearchTest() {
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
     * Test of getResults method, of class PokemonSearch.
     */
    @Test
    public void testGetResults() {
        //TODO: fix this test. getResults() is now returning null (only in test
        //but works fine normally)
        System.out.println("getResults test");
        
        ArrayList<String> fakePkmnThatLearnAllMoves = new ArrayList<>();
        fakePkmnThatLearnAllMoves.add("bulbasaur");
        fakePkmnThatLearnAllMoves.add("squirtle");
        fakePkmnThatLearnAllMoves.add("charmander");
  


        PokemonSearch search = new PokemonSearch(testMoveList);
        
        ItemMatch mockItemMatch = mock(ItemMatch.class);
        search.setItemMatch(mockItemMatch);
        when(mockItemMatch.pkmnThatLearnAllMoves(any()))
                .thenReturn(fakePkmnThatLearnAllMoves);

        //getResults calls getMovesFromAPI
        //when getMovesFromAPI uses a Request to get moves the mock will return
        //the test moves       
        Request mockRequest = mock(Request.class);
        when(mockRequest.searchPokemon(anyString()))
                .thenReturn(testMove1)
                .thenReturn(testMove2)
                .thenReturn(testMove3)
                .thenReturn(testMove4);
        
        Pokemon mockPokemon = mock(Pokemon.class);
        
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
