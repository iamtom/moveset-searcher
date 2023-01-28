package com.mycompany.pokemonmovefinder;

import java.util.ArrayList;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class MovesInputValidator implements ConstraintValidator<ValidateMovesInput,String> {
    @Autowired
    MoveDataRepository moveDataRepository;
    
    @Override
    public boolean isValid(String move, ConstraintValidatorContext cvc) {
        ArrayList<MoveData> moveSelectList = moveDataRepository.findAll();
        
        boolean validity = true;
        
        //TODO: why is this always returning false?
        //search works without isBlank
        if(moveSelectList.contains(move) || move.isBlank()){
            validity = false;
        }
        
        return validity;
    }
    
}
