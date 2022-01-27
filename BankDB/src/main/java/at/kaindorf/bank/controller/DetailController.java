package at.kaindorf.bank.controller;

import at.kaindorf.bank.pojos.Customer;
import at.kaindorf.bank.pojos.GiroAccount;
import at.kaindorf.bank.pojos.SavingsAccount;
import at.kaindorf.bank.pojos.Util;
import at.kaindorf.bank.repo.AddressRepository;
import at.kaindorf.bank.repo.CustomerRepository;
import at.kaindorf.bank.repo.GiroAccountRepository;
import at.kaindorf.bank.repo.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 27.01.2022
    Time: 15:26
*/
@Controller
@SessionAttributes({"util", "giros", "savings"})
@RequestMapping("/detail")
public class DetailController {
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
        model.addAttribute("util", new Util());
    }

    @GetMapping
    public String getCustomer(@ModelAttribute("util") Util util, Model model){
        System.out.println(util);
        Customer c = customerRepository.findById(util.getCustomerId()).get();
        System.out.println(c.getAccounts());

        //model.addAttribute("giros", giroAccounts);
        //model.addAttribute("savings", savingsAccounts);
        model.addAttribute("customer", c);

        return "detailView";
    }
}
