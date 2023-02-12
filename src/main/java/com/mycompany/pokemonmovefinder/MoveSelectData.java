package com.mycompany.pokemonmovefinder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MoveSelectData {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String displayText;
    private String basicText;
    
    public MoveSelectData() {
        
    }

    public MoveSelectData(String displayText, String basicText) {
        this.displayText = displayText;
        this.basicText = basicText;
    }

    public Long getId() {
        return id;
    }

    public String getDisplayText() {
        return displayText;
    }

    public String getBasicText() {
        return basicText;
    }

    @Override
    public String toString() {
        return "MoveSelectData{" + "displayText=" + displayText + ", basicText=" + basicText + '}';
    }
    
}
