package com.mycompany.pokemonmovefinder;

import com.mycompany.pokemonmovefinder.results.Result;
import com.mycompany.pokeapilibrary.move.Move;
import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.NamedAPIResource;
import com.mycompany.pokeapilibrary.pokemon.Pokemon;
import com.mycompany.pokeapilibrary.pokemon.PokemonMove;
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
    
    private ArrayList<Pokemon> fakePokemonObjects;
    private ArrayList<PokemonMove> expPokemonMoves;

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
        //these have already been confirmed by ItemMatch as the ones that can
        //learn all 4 moves
        Pokemon bulbasaur = new Pokemon();
        bulbasaur.setName("bulbasaur");
        Pokemon charmander = new Pokemon();
        charmander.setName("charmander");
        Pokemon squirtle = new Pokemon();
        squirtle.setName("squirtle");
        
        this.fakePokemonObjects = new ArrayList<>();
        this.fakePokemonObjects.add(bulbasaur);
        this.fakePokemonObjects.add(charmander);
        this.fakePokemonObjects.add(squirtle);
               
        //make some fake PokemonMoves and them to Pokemon
        //do tackle, earthquake, surf, tail-whip as ones we want
        //add fire-blast, hyper-beam as decoys
        NamedAPIResource tackleNAR = new NamedAPIResource();
        tackleNAR.setName("tackle");
        PokemonMove tackle = new PokemonMove();
        tackle.setMove(tackleNAR);
        
        NamedAPIResource earthquakeNAR = new NamedAPIResource();
        earthquakeNAR.setName("earthquake");
        PokemonMove earthquake = new PokemonMove();
        earthquake.setMove(earthquakeNAR);
        
        NamedAPIResource surfNAR = new NamedAPIResource();
        surfNAR.setName("surf");
        PokemonMove surf = new PokemonMove();
        surf.setMove(surfNAR);
        
        NamedAPIResource tailWhipNAR = new NamedAPIResource();
        tailWhipNAR.setName("tail-whip");
        PokemonMove tailWhip = new PokemonMove();
        tailWhip.setMove(tailWhipNAR);
        
        NamedAPIResource fireBlastNAR = new NamedAPIResource();
        fireBlastNAR.setName("fire-blast");
        PokemonMove fireBlast = new PokemonMove();
        fireBlast.setMove(fireBlastNAR);
        
        NamedAPIResource hyperBeamNAR = new NamedAPIResource();
        hyperBeamNAR.setName("hyper-beam");
        PokemonMove hyperBeam = new PokemonMove();
        hyperBeam.setMove(hyperBeamNAR);
        
        ArrayList<PokemonMove> fakePokemonMoves = new ArrayList<>();
        fakePokemonMoves.add(tackle);
        fakePokemonMoves.add(earthquake);
        fakePokemonMoves.add(surf);
        fakePokemonMoves.add(tailWhip);
        fakePokemonMoves.add(fireBlast);
        fakePokemonMoves.add(hyperBeam);
        
        for(Pokemon pokemon : fakePokemonObjects) {
            pokemon.setMoves(fakePokemonMoves);
        }
        
        expPokemonMoves = new ArrayList<>();
        expPokemonMoves.add(tackle);
        expPokemonMoves.add(earthquake);
        expPokemonMoves.add(surf);
        expPokemonMoves.add(tailWhip);
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getResults method, of class PokemonSearch.
     */
    @Test
    public void testGetResults() {
        System.out.println("getResults test");
        
        ArrayList<String> fakePkmnThatLearnAllMoves = new ArrayList<>();
        fakePkmnThatLearnAllMoves.add("bulbasaur");
        fakePkmnThatLearnAllMoves.add("squirtle");
        fakePkmnThatLearnAllMoves.add("charmander");
        
        ArrayList<Move> testMoveList = new ArrayList<>();
        Move move1 = new Move();
        move1.setName("tackle");
        Move move2 = new Move();
        move2.setName("earthquake");
        Move move3 = new Move();
        move3.setName("surf");
        Move move4 = new Move();
        move4.setName("tail-whip");     
        testMoveList.add(move1);
        testMoveList.add(move2);
        testMoveList.add(move3);
        testMoveList.add(move4);
        
        PokemonSearch search = new PokemonSearch(testMoveList);
        
        //mock ItemMatch because behaviour of ItemMatch is tested in its own test
        ItemMatch mockItemMatch = mock(ItemMatch.class);
        search.setItemMatch(mockItemMatch);
        when(mockItemMatch.pkmnThatLearnAllMoves(any()))
                .thenReturn(fakePkmnThatLearnAllMoves);

        //instead of receiving Pokemon from the API we instead return the fake Pokemon
        Request mockRequest = mock(Request.class);
        when(mockRequest.searchPokemon(anyString()))
                .thenReturn(fakePokemonObjects.get(0))
                .thenReturn(fakePokemonObjects.get(1))
                .thenReturn(fakePokemonObjects.get(2));       
        search.setRequestObject(mockRequest);
        
        ArrayList<Result> expResult = new ArrayList<>();        
        for(Pokemon pokemon : this.fakePokemonObjects) {
            Result result = new Result(pokemon.getName(), this.expPokemonMoves);
            expResult.add(result);
        }

        ArrayList<Result> result = search.getResults();

        assertThat(result).usingRecursiveComparison().isEqualTo(expResult);

    }
    
}
