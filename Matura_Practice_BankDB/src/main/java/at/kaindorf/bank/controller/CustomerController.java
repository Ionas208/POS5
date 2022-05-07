package at.kaindorf.bank.controller;

import at.kaindorf.bank.pojos.*;
import at.kaindorf.bank.repo.AccountRepository;
import at.kaindorf.bank.repo.CustomerRepository;
import at.kaindorf.bank.repo.GiroAccountRepository;
import at.kaindorf.bank.repo.SavingsAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 06.05.2022
    Time: 16:17
*/
@Controller
@Slf4j
@SessionAttributes({"customers"})
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("customers", new ArrayList<>());
        model.addAttribute("giroAccounts", new ArrayList<>());
        model.addAttribute("savingsAccounts", new ArrayList<>());
    }

    @GetMapping
    public String getCustomer() {
        return "customerView";
    }

    @GetMapping("/filter")
    public String filterByLastname(Model model, @RequestParam(name = "lastname", required = true) String lastname) {
        List<Customer> customers = customerRepository.findAllByLastnameContaining(lastname, Sort.by("lastname", "firstname"));
        model.addAttribute("customers", customers);
        return "customerView";
    }


}