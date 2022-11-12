package com.mycompany.pokemonmovefinder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/moves")
    public String movesForm(Model model) {
        model.addAttribute("movesInput", new MovesInput());
        return "moves";
    }

    @PostMapping("/moves")
    public String movesSubmit(@ModelAttribute MovesInput movesInput, Model model) {
        MovesInput test = new MovesInput();
        test.setMove1(movesInput.getMove1() + "test");
        test.setMove2(movesInput.getMove2() + "test");
        test.setMove3(movesInput.getMove3() + "test");
        test.setMove4(movesInput.getMove4() + "test");
        System.out.println("");
        System.out.println(movesInput.getMove1());
        System.out.println(movesInput.getMove2());
        System.out.println(movesInput.getMove3());
        System.out.println(movesInput.getMove4());

        model.addAttribute("test", test);
        return "result";
    }
  
}