package at.kaindorf.bank.controller;

import at.kaindorf.bank.pojos.Account;
import at.kaindorf.bank.pojos.Customer;
import at.kaindorf.bank.pojos.GiroAccount;
import at.kaindorf.bank.pojos.SavingsAccount;
import at.kaindorf.bank.repo.AccountRepository;
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
    Date: 07.05.2022
    Time: 11:50
*/
@Controller
@Slf4j
@SessionAttributes({"giroAccounts", "savingsAccounts", "withdrawError", "withdrawErrorId", "customer"})
@RequestMapping("account")
public class AccountController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private SavingsAccountRepository savingsAccountRepository;
    @Autowired
    private GiroAccountRepository giroAccountRepository;

    @GetMapping
    public String getCustomerById(Model model, @RequestParam(name="customerId") Long customerId) {
        model.addAttribute("withdrawErrorId", null);
        model.addAttribute("withdrawError", null);
        Customer c = customerRepository.findById(customerId).get();

        List<GiroAccount> giroAccounts = giroAccountRepository.findAll();
        giroAccounts.removeIf(a -> !a.getCustomers().contains(c));
        model.addAttribute("giroAccounts", giroAccounts);

        List<SavingsAccount> savingsAccounts = savingsAccountRepository.findAll();
        savingsAccounts.removeIf(a -> !a.getCustomers().contains(c));
        model.addAttribute("savingsAccounts", savingsAccounts);

        model.addAttribute("customer", customerId);

        return "accountView";
    }

    @PostMapping("withdraw")
    public String withdraw(Model model,
                           @RequestParam(name="amount") Double amount,
                           @RequestParam(name="action") String action,
                           @RequestParam(name="accountId") Long accountId
    ){
        model.addAttribute("withdrawErrorId", null);
        model.addAttribute("withdrawError", null);
        if(giroAccountRepository.existsById(accountId)){
            GiroAccount a = giroAccountRepository.getById(accountId);
            Double newBalance = action.equals("+") ? a.getBalance()+amount : action.equals("-") ? a.getBalance()-amount : null;
            if(newBalance<a.getOverdraft()*-1){
                model.addAttribute("withdrawErrorId", accountId);
                model.addAttribute("withdrawError", "Withdrawal not possible: Withdrawal exceeds overdraft of "+ a.getOverdraft());
                return "accountView";
            }
            a.setBalance(newBalance);
            giroAccountRepository.flush();

            Customer c = customerRepository.getById((Long) model.getAttribute("customer"));
            List<GiroAccount> giroAccounts = giroAccountRepository.findAll();
            giroAccounts.removeIf(ac -> !ac.getCustomers().contains(c));
            model.addAttribute("giroAccounts", giroAccounts);

        }else if(savingsAccountRepository.existsById(accountId)){
            SavingsAccount a = savingsAccountRepository.getById(accountId);
            Double newBalance = action.equals("+") ? a.getBalance()+amount : action.equals("-") ? a.getBalance()-amount : null;
            if(newBalance<0){
                model.addAttribute("withdrawErrorId", accountId);
                model.addAttribute("withdrawError", "Withdrawal not possible: Withdrawal would result in overdraft");
                return "accountView";
            }
            a.setBalance(newBalance);
            savingsAccountRepository.flush();

            Customer c = customerRepository.getById((Long) model.getAttribute("customer"));
            List<SavingsAccount> savingsAccounts = savingsAccountRepository.findAll();
            savingsAccounts.removeIf(ac -> !ac.getCustomers().contains(c));
            model.addAttribute("savingsAccounts", savingsAccounts);
        }

        return "accountView";
    }
}
