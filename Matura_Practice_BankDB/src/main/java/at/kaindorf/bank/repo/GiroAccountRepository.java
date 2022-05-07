package at.kaindorf.bank.repo;

import at.kaindorf.bank.pojos.GiroAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiroAccountRepository extends JpaRepository<GiroAccount, Long> {
}