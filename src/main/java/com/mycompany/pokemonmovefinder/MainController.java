package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.Request;
import com.mycompany.pokeapilibrary.SimpleInfo;
import com.mycompany.pokeapilibrary.StringFormatter;
import com.mycompany.pokeapilibrary.move.Moves;
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
        //this code can go in MoveFinderTools?
        Request request = new Request();
        Moves moves = request.allMoves(0, 844);
        ArrayList<SimpleInfo> results = moves.getResults();       
        ArrayList<MoveData> moveSelectList = new ArrayList<>();        
        for (int i = 0; i < results.size(); i++) {
            String value = results.get(i).getName();
            String text = StringFormatter.basicFormat(value);
            
            MoveData newItem = new MoveData(text, value);
            moveSelectList.add(newItem);
        }
        
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
        return "result";
    }
  
}