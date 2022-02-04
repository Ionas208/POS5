package at.kaindorf.exam.repo;

import at.kaindorf.exam.pojos.Exam;
import at.kaindorf.exam.pojos.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findAllByStudent(Student student);
}