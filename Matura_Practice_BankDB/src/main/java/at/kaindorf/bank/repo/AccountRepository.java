package at.kaindorf.bank.repo;

import at.kaindorf.bank.pojos.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT AVG(a) FROM Account a WHERE a.balance < 0")
    Double getAverageBalanceOfNegative();

    @Query("SELECT COUNT(a) FROM Account a WHERE a.customers.size>1")
    Integer getNumberOfAccountsWithMultipleCustomers();
}