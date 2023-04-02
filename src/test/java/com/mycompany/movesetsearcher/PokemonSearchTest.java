package com.mycompany.movesetsearcher;

import com.mycompany.movesetsearcher.PokemonSearch;
import com.mycompany.movesetsearcher.ItemMatch;
import com.mycompany.movesetsearcher.results.Result;
import com.mycompany.movesetsearcher.results.ResultFactory;
import com.mycompany.pokeapilibrary.move.Move;
import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.NamedAPIResource;
import com.mycompany.pokeapilibrary.pokemon.Pokemon;
import com.mycompany.pokeapilibrary.pokemon.PokemonMove;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokemonSearchTest {

    private ArrayList<String> fakePkmnThatLearnAllMoves;
    private ArrayList<String> expMoveNames;
    private ArrayList<Pokemon> fakePokemonObjects;
    private ArrayList<PokemonMove> expPokemonMoves;
    private ArrayList<Move> fakeMoveList;
    private Result testResult;

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
        //make fake Pokemon
        //do bulbasaur, squirtle, charmander
        //in this scenario these have already been confirmed by ItemMatch 
        //as the ones that can learn all 4 moves

        //setting up fakeMoveList
        Move move1 = new Move();
        Move move2 = new Move();
        Move move3 = new Move();
        Move move4 = new Move();
        move1.setName("tackle");
        move2.setName("earthquake");
        move3.setName("surf");
        move4.setName("tail-whip");
        this.fakeMoveList = new ArrayList<>();
        this.fakeMoveList.add(move1);
        this.fakeMoveList.add(move2);
        this.fakeMoveList.add(move3);
        this.fakeMoveList.add(move4);

        //setting up fake PokemonMove objects
        ArrayList<PokemonMove> fakePokemonMoves = new ArrayList<>();

        PokemonMove pMove1 = new PokemonMove();
        NamedAPIResource nar1 = new NamedAPIResource();
        nar1.setName("tackle");
        pMove1.setMove(nar1);
        fakePokemonMoves.add(pMove1);
        PokemonMove pMove2 = new PokemonMove();
        NamedAPIResource nar2 = new NamedAPIResource();
        nar1.setName("surf");
        pMove1.setMove(nar2);
        fakePokemonMoves.add(pMove2);
        PokemonMove pMove3 = new PokemonMove();
        NamedAPIResource nar3 = new NamedAPIResource();
        nar1.setName("earthquake");
        pMove1.setMove(nar3);
        fakePokemonMoves.add(pMove3);
        PokemonMove pMove4 = new PokemonMove();
        NamedAPIResource nar4 = new NamedAPIResource();
        nar1.setName("tail-whip");
        pMove1.setMove(nar4);
        fakePokemonMoves.add(pMove4);

        //setting up fake Pokemon objects
        Pokemon bulbasaur = new Pokemon();
        bulbasaur.setName("bulbasaur");
        bulbasaur.setMoves(fakePokemonMoves);
        Pokemon charmander = new Pokemon();
        charmander.setName("charmander");
        charmander.setMoves(fakePokemonMoves);
        Pokemon squirtle = new Pokemon();
        squirtle.setName("squirtle");
        squirtle.setMoves(fakePokemonMoves);

        this.fakePokemonObjects = new ArrayList<>();
        this.fakePokemonObjects.add(bulbasaur);
        this.fakePokemonObjects.add(squirtle);
        this.fakePokemonObjects.add(charmander);

        this.fakePkmnThatLearnAllMoves = new ArrayList<>();
        this.fakePkmnThatLearnAllMoves.add("bulbasaur");
        this.fakePkmnThatLearnAllMoves.add("squirtle");
        this.fakePkmnThatLearnAllMoves.add("charmander");

        this.expMoveNames = new ArrayList<>();
        this.expMoveNames.add("tackle");
        this.expMoveNames.add("surf");
        this.expMoveNames.add("earthquake");
        this.expMoveNames.add("tail-whip");

        this.testResult = new Result("pokemon name", new LinkedHashMap<>());

    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getResults method, of class PokemonSearch.
     */
    //TODO: this test needs rewriting as it is not working
    @Test
    public void testGetResults() {
        System.out.println("getResults test");

        PokemonSearch search = new PokemonSearch(this.fakeMoveList);

        //mock ItemMatch because behaviour of ItemMatch is tested in its own test
        ItemMatch mockItemMatch = mock(ItemMatch.class);
        when(mockItemMatch.pkmnThatLearnAllMoves(any()))
                .thenReturn(this.fakePkmnThatLearnAllMoves);
        search.setItemMatch(mockItemMatch);

        //instead of receiving Pokemon from the API we instead return the fake Pokemon
        //this is in the getPokemonObjects private method
        Request mockRequest = mock(Request.class);
        when(mockRequest.searchPokemon(anyString()))
                .thenReturn(fakePokemonObjects.get(0))
                .thenReturn(fakePokemonObjects.get(1))
                .thenReturn(fakePokemonObjects.get(2));
        search.setRequestObject(mockRequest);

        ResultFactory mockResultFactory = mock(ResultFactory.class);
        when(mockResultFactory.createResultGroupedByVersion(anyString(), any()))
                .thenReturn(testResult);
        search.setResultFactory(mockResultFactory);

        System.out.println(testResult);

        ArrayList<Result> results = search.getResults();
        System.out.println("Results:  " + results);
        assertEquals(3, results.size());
    }

}
