package at.kaindorf.intro.data;

import at.kaindorf.intro.pojos.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}