package at.kaindorf.bank.controller;

import at.kaindorf.bank.pojos.Customer;
import at.kaindorf.bank.pojos.Util;
import at.kaindorf.bank.repo.AddressRepository;
import at.kaindorf.bank.repo.CustomerRepository;
import at.kaindorf.bank.repo.GiroAccountRepository;
import at.kaindorf.bank.repo.SavingsAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 22.12.2021
    Time: 15:12
*/
@Controller
@Slf4j
@RequestMapping("/list")
@SessionAttributes({"customers", "util", "customer"})
public class ListController {
    @Autowired
    private SavingsAccountRepository savingsAccountRepository;
    @Autowired
    private GiroAccountRepository giroAccountRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @ModelAttribute
    public void addAttributes(Model model){
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer());
        model.addAttribute("util", new Util());
    }

    @GetMapping
    public String list(Model model){
        return "listView";
    }

    @PostMapping
    public String search(@ModelAttribute("util") Util searchUtil, Model model){
        List<Customer> customers = customerRepository.findAllByLastnameContaining(searchUtil.getLastname());
        model.addAttribute("customers", customers);
        return "listView";
    }
}
