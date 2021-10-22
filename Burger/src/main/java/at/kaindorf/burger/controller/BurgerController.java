package at.kaindorf.burger.controller;

import at.kaindorf.burger.pojos.Burger;
import at.kaindorf.burger.pojos.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class BurgerController {

    private List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("120B", "120g Ground Beef", Ingredient.Type.PATTY),
            new Ingredient("160B", "160g Ground Beef", Ingredient.Type.PATTY),
            new Ingredient("140T", "140g Turkey", Ingredient.Type.PATTY),
            new Ingredient("TOMA", "Tomato", Ingredient.Type.VEGGIE),
            new Ingredient("SALA", "Salad", Ingredient.Type.VEGGIE),
            new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
            new Ingredient("GOUD", "Gouda", Ingredient.Type.CHEESE)
    );

    @ModelAttribute
    public void addAttributes(Model model){
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
    public String processBurger(@ModelAttribute("designBurger") Burger burger){
        log.info(burger.toString());
        return "designForm";
    }
}
