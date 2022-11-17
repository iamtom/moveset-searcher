package com.mycompany.pokemonmovefinder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MoveData {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private final String text;
    private final String value;

    public MoveData(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DropDownItem{" + "text=" + text + ", value=" + value + '}';
    }
    
}
