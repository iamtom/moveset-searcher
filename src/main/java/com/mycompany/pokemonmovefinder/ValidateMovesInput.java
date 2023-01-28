package com.mycompany.pokemonmovefinder;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MovesInputValidator.class)
public @interface ValidateMovesInput {
    public String message() default "Invalid input";
    
    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
