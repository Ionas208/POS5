package at.kaindorf.plf.repo;

import at.kaindorf.plf.pojos.Department;
import at.kaindorf.plf.pojos.Employee;
import at.kaindorf.plf.pojos.Salgrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByDept(Department d);

    @Query("SELECT MAX(e.empno) FROM emp e")
    Integer findMaxEmpno();

    @Query("SELECT e, s FROM emp e INNER JOIN Salgrade s ON e.sal BETWEEN s.losal AND s.hisal")
    Map<Employee, Salgrade> findAllWithSalgrade();
}