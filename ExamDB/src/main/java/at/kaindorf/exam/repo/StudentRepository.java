package at.kaindorf.exam.repo;

import at.kaindorf.exam.pojos.Classname;
import at.kaindorf.exam.pojos.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findAllByClassname(Classname classname, Pageable page);
}