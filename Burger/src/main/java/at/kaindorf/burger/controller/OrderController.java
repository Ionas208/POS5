package at.kaindorf.burger.controller;

import at.kaindorf.burger.pojos.Burger;
import at.kaindorf.burger.pojos.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
    Created by: Jonas Seidl
    Date: 05.11.2021
    Time: 10:24
*/
@Controller
@Slf4j
@RequestMapping("/orders")
public class OrderController {
    @GetMapping("/current")
    public String requestOrder(Model model, @SessionAttribute Burger designBurger){
        log.info(designBurger+"");
        model.addAttribute("designBurger", designBurger);
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String performOrder(Model model, @ModelAttribute Order order){
        log.info(order.toString());
        return "redirect:/design";
    }
}
