package at.kaindorf.burger.controller;

import at.kaindorf.burger.pojos.Burger;
import at.kaindorf.burger.pojos.Ingredient;
import at.kaindorf.burger.repo.BurgerRepository;
import at.kaindorf.burger.repo.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/*
    Created by: Jonas Seidl
    Date: 22.10.2021
    Time: 10:51
*/
@Controller
@Slf4j
@RequestMapping("/design")
@SessionAttributes("designBurger")
public class BurgerController {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private BurgerRepository burgerRepository;
    private List<Ingredient> ingredients;

    @ModelAttribute
    public void addAttributes(Model model){
        this.ingredients = ingredientRepository.findAll();
        Map<String, List<Ingredient>> ingredients = new HashMap<>();

        for(Ingredient.Type t: Ingredient.Type.values()){
            ingredients.put(t.name().toLowerCase(), filterByType(t));
        }

        model.addAttribute("ingredients", ingredients);
        model.addAttribute("designBurger", new Burger());
    }

    private List<Ingredient> filterByType(Ingredient.Type t){
        return ingredients.stream()
                .filter(i -> i.getType().equals(t))
                .collect(Collectors.toList());
    }

    @GetMapping
    public String showDesign(){
        return "designForm";
    }

    @PostMapping
    public String processBurger(@Valid @ModelAttribute("designBurger") Burger burger, Errors errors){
        if(errors.hasErrors()){
            log.info(errors.getAllErrors().toString());
            return "designForm";
        }
        burgerRepository.save(burger);
        return "redirect:/orders/current";
    }
}
