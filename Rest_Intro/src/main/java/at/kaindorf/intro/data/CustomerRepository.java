package at.kaindorf.intro.data;

import at.kaindorf.intro.pojos.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}