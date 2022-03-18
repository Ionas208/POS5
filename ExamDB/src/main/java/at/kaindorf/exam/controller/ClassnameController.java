package at.kaindorf.exam.controller;

import at.kaindorf.exam.pojos.Classname;
import at.kaindorf.exam.repo.ClassnameRepository;
import at.kaindorf.exam.repo.ExamRepository;
import at.kaindorf.exam.repo.StudentRepository;
import at.kaindorf.exam.repo.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/*
    Created by: Jonas Seidl
    Date: 04.02.2022
    Time: 10:32
*/
@RestController
@Slf4j
@RequestMapping("classname")
@CrossOrigin(origins = "*")
public class ClassnameController {
    @Autowired
    private ClassnameRepository classnameRepository;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Classname>> getAll() {
        List<Classname> classnames = classnameRepository.findAll(Sort.by("classname"));
        return ResponseEntity.of(Optional.of(classnames));
    }
}
