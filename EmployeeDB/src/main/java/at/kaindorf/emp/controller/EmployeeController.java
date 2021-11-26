package at.kaindorf.emp.controller;

import at.kaindorf.emp.pojos.Department;
import at.kaindorf.emp.pojos.Employee;
import at.kaindorf.emp.repo.DepartmentRepository;
import at.kaindorf.emp.repo.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
    Created by: Jonas Seidl
    Date: 26.11.2021
    Time: 11:13
*/
@Controller
@Slf4j
@RequestMapping("/list")
@SessionAttributes({"departments", "employees", "chosenDept"})
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("chosenDept", new Department());
        model.addAttribute("employees", employeeRepository.findAll());
    }


    @GetMapping()
    public String showDepartments(Model model, @ModelAttribute("chosenDept") Department chosenDept){
        System.out.println(chosenDept+"------");
        if(chosenDept.getDeptName() != null){
            List<Employee> employees = employeeRepository.findAll();
            employees = employees.stream().filter(e -> e.getDepartment().equals(chosenDept)).collect(Collectors.toList());
            model.addAttribute("employees", employees);
        }
        return "listView";
    }
}
