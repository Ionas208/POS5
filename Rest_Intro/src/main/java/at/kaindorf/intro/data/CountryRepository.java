package at.kaindorf.intro.data;

import at.kaindorf.intro.pojos.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}