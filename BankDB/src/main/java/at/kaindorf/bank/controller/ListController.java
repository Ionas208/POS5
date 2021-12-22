package at.kaindorf.bank.controller;

import at.kaindorf.bank.pojos.Address;
import at.kaindorf.bank.pojos.Customer;
import at.kaindorf.bank.pojos.SearchUtil;
import at.kaindorf.bank.repo.AddressRepository;
import at.kaindorf.bank.repo.CustomerRepository;
import at.kaindorf.bank.repo.GiroAccountRepository;
import at.kaindorf.bank.repo.SavingsAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 22.12.2021
    Time: 15:12
*/
@Controller
@Slf4j
@RequestMapping("/list")
@SessionAttributes({"customers", "serachUtil"})
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
        model.addAttribute("searchUtil", new SearchUtil());
    }

    @GetMapping
    public String list(Model model){
        return "listView";
    }
}
