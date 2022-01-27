package at.kaindorf.intro.controller;

import at.kaindorf.intro.data.CustomerRepository;
import at.kaindorf.intro.pojos.Customer;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/*
    Created by: Jonas Seidl
    Date: 14.01.2022
    Time: 10:54
*/
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepo;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return ResponseEntity.of(customerRepo.findById(id));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        Pageable page = PageRequest.of(0, 5, Sort.by("lastname").descending());
        return ResponseEntity.ok(customerRepo.findAll(page));
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        try{
            customerRepo.save(customer);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(customer.getCustomerID())
                    .toUri();
            return ResponseEntity.created(location).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
