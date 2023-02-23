package com.mycompany.pokemonmovefinder;

import com.mycompany.pokeapilibrary.move.Move;
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
    MoveSelectDataRepository moveSelectDataRepository;

    @GetMapping("/")
    public String movesForm(Model model) {
        ArrayList<MoveSelectData> moveSelectList = moveSelectDataRepository.findAll();

        model.addAttribute("movesInput", new MovesInputDTO());
        model.addAttribute("moveSelectList", moveSelectList);
        return "movefinder";
    }

    @PostMapping("/")
    public String movesSubmit(@Valid @ModelAttribute MovesInputDTO movesInput,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "movefinder";
        }
        
        Mapper mapper = new Mapper();
        System.out.println("Moves input " + movesInput);
        ArrayList<Move> moveList = mapper.toMoveList(movesInput);
        MoveSearch search = new MoveSearch(moveList);
        ArrayList<Result> searchResults = search.getResults();
        model.addAttribute("searchResults", searchResults);

        return "result";
    }

}
