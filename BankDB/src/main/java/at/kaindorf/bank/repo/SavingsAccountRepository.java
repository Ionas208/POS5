package at.kaindorf.bank.repo;

import at.kaindorf.bank.pojos.Customer;
import at.kaindorf.bank.pojos.GiroAccount;
import at.kaindorf.bank.pojos.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
}