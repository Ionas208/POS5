package at.kaindorf.bank.repo;

import at.kaindorf.bank.pojos.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}