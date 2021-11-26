package at.kaindorf.emp.repo;

import at.kaindorf.emp.pojos.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}