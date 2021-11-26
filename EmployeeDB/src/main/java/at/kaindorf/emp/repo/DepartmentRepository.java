package at.kaindorf.emp.repo;

import at.kaindorf.emp.pojos.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}