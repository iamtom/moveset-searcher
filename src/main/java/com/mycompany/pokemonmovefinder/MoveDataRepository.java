package com.mycompany.pokemonmovefinder;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

public interface MoveDataRepository extends CrudRepository<MoveData, Long> {
    
    ArrayList<MoveData> findAll();
    
}
