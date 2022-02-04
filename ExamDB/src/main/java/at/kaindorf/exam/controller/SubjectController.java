package at.kaindorf.exam.controller;

import at.kaindorf.exam.repo.ClassnameRepository;
import at.kaindorf.exam.repo.ExamRepository;
import at.kaindorf.exam.repo.StudentRepository;
import at.kaindorf.exam.repo.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Created by: Jonas Seidl
    Date: 04.02.2022
    Time: 10:32
*/
@RestController
@Slf4j
@RequestMapping("subject")
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {
    @Autowired
    private ClassnameRepository classnameRepository;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
}
