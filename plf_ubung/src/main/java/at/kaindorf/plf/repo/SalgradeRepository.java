package at.kaindorf.plf.repo;

import at.kaindorf.plf.pojos.Employee;
import at.kaindorf.plf.pojos.Salgrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SalgradeRepository extends JpaRepository<Salgrade, Integer> {
    @Query("SELECT s FROM Salgrade s WHERE ?1 BETWEEN s.losal AND s.hisal")
    Salgrade findBySal(Integer sal);
}