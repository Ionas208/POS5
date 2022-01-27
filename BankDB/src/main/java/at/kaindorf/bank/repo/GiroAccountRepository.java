package at.kaindorf.bank.repo;

import at.kaindorf.bank.pojos.Customer;
import at.kaindorf.bank.pojos.GiroAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GiroAccountRepository extends JpaRepository<GiroAccount, Long> {
}