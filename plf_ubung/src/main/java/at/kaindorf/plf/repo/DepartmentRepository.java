package at.kaindorf.plf.repo;

import at.kaindorf.plf.pojos.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}