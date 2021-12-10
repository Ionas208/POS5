package at.kaindorf.emp.controller;

import at.kaindorf.emp.pojos.Department;
import at.kaindorf.emp.pojos.Employee;
import at.kaindorf.emp.pojos.EmployeeUtil;
import at.kaindorf.emp.pojos.Gender;
import at.kaindorf.emp.repo.DepartmentRepository;
import at.kaindorf.emp.repo.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    Created by: Jonas Seidl
    Date: 10.12.2021
    Time: 10:02
*/
@Controller
@Slf4j
@RequestMapping("/insert")
@SessionAttributes({"departments", "employee"})
public class InsertEmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentRepository.findAll());
    }

    @GetMapping
    public String showForm(){
        return "insertView";
    }

    @PostMapping
    public String insertEmployee(Model model, @Valid @ModelAttribute("employee") Employee emp, Errors errors){
        if(errors.hasErrors()){
            log.info(errors.getAllErrors().toString());
            return "insertView";
        }
        Integer empNo = employeeRepository.findMaxEmployeeNo()+1;
        emp.setEmployeeNo(empNo);
        employeeRepository.save(emp);
        employeeRepository.flush();

        return "redirect:/list";
    }
}
