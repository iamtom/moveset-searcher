package com.mycompany.pokemonmovefinder;

import com.mycompany.pokemonmovefinder.tools.MoveFinderTools;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    
    @Autowired
    MoveDataRepository moveDataRepository;

    @GetMapping("/moves")
    public String movesForm(Model model) {
        ArrayList<MoveData> moveSelectList = moveDataRepository.findAll();
       
        model.addAttribute("movesInput", new MovesInput());
        model.addAttribute("moveSelectList", moveSelectList);
        return "moves";
    }

    @PostMapping("/moves")
    public String movesSubmit(@ModelAttribute MovesInput movesInput, Model model) {       
        System.out.println("Moves selected:");
        System.out.println(movesInput.getMove1());
        System.out.println(movesInput.getMove2());
        System.out.println(movesInput.getMove3());
        System.out.println(movesInput.getMove4());
        
        Search search = new Search(movesInput);
        ArrayList<Result> searchResults = search.getResults();
        model.addAttribute("searchResults", searchResults);       
        
        return "result";
    }
     
}