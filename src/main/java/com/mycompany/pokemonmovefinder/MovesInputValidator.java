package com.mycompany.pokemonmovefinder;

import java.util.ArrayList;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class MovesInputValidator implements ConstraintValidator<ValidateMovesInput,String> {
    @Autowired
    MoveSelectDataRepository moveSelectDataRepository;
    
    @Override
    public boolean isValid(String move, ConstraintValidatorContext cvc) {
        ArrayList<MoveSelectData> moveSelectList = moveSelectDataRepository.findAll();

        boolean validity = false;

        if(moveSelectList.stream().anyMatch(o -> move.equals(o.getBasicText())) || move.isBlank()){
            validity = true;
        }
        
        return validity;
    }
    
}
