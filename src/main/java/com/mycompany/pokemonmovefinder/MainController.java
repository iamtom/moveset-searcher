package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.SimpleInfo;
import com.mycompany.pokeapilibrary.StringFormatter;
import com.mycompany.pokeapilibrary.move.PagesOfMoves;
import com.mycompany.pokemonmovefinder.tools.MoveFinderTools;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/moves")
    public String movesForm(Model model) {
        //replace following with getting the data from database
        //ArrayList<DropDownItem> moveSelectList = moveDataRepository.findAll(); something like this

        ArrayList<MoveData> moveSelectList = MoveFinderTools.getArrayListOfMoveDataFromAPI();
        
        //System.out.println(moveList);
       
        model.addAttribute("movesInput", new MovesInput());
        model.addAttribute("moveSelectList", moveSelectList);
        return "moves";
    }

    @PostMapping("/moves")
    public String movesSubmit(@ModelAttribute MovesInput movesInput, Model model) {
        MovesInput test = new MovesInput();
        test.setMove1(movesInput.getMove1());
        test.setMove2(movesInput.getMove2());
        test.setMove3(movesInput.getMove3());
        test.setMove4(movesInput.getMove4());
        System.out.println("");
        System.out.println(movesInput.getMove1());
        System.out.println(movesInput.getMove2());
        System.out.println(movesInput.getMove3());
        System.out.println(movesInput.getMove4());

        model.addAttribute("test", test);
        
        Search search = new Search(movesInput);
        
        return "result";
    }
     
}