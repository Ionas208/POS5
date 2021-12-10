package at.kaindorf.emp.repo;

import at.kaindorf.emp.pojos.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT MAX(e.employeeNo) FROM Employee e WHERE e.employeeNo < 499703")
    Integer findMaxEmployeeNo();
}