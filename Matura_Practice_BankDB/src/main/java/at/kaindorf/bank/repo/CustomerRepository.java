package at.kaindorf.bank.repo;

import at.kaindorf.bank.pojos.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByLastnameContaining(String lastname, Sort sort);

    //@Query("SELECT c FROM Customer c WHERE c IN (SELECT a.customers FROM Account a WHERE a.balance = (SELECT MAX(a2.balance) FROM Account a2))")
    //Customer getCustomerByHighestBalance();
    @Query("SELECT a.customers FROM Account a WHERE a.balance = (SELECT MAX(a2.balance) FROM Account a2)")
    List<Customer> getCustomerByHighestBalance();
}