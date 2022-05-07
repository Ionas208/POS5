package at.kaindorf.bank.repo;

import at.kaindorf.bank.pojos.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByLastnameContaining(String lastname, Sort sort);

    @Query(name = "getTotalBalance")
    Double getTotalBalance(Customer c);
}