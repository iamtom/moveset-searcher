package com.mycompany.pokemonmovefinder;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

public interface MoveSelectDataRepository extends CrudRepository<MoveSelectData, Long> {
    
    ArrayList<MoveSelectData> findAll();
    
}
