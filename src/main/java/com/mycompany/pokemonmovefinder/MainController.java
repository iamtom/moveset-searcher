package com.mycompany.pokemonmovefinder;

import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {
    @Autowired
    MoveDataRepository moveDataRepository;

    @GetMapping("/")
    public String movesForm(Model model) {
        ArrayList<MoveData> moveSelectList = moveDataRepository.findAll();
       
        model.addAttribute("movesInput", new MovesInput());
        model.addAttribute("moveSelectList", moveSelectList);
        return "movefinder";
    }

    @PostMapping("/")
    public String movesSubmit(@Valid @ModelAttribute MovesInput movesInput, 
            BindingResult bindingResult, Model model) {   
        if(bindingResult.hasErrors()){
            return "movefinder";
        }
        
        Search search = new Search(movesInput);
        ArrayList<Result> searchResults = search.getResults();
        model.addAttribute("searchResults", searchResults);       
        
        return "result";
    }
     
}