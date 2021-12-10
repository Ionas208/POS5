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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.Collections;
import java.util.Comparator;
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
@SessionAttributes({"departments", "employees", "chosenDept", "employeeUtil"})
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @ModelAttribute
    public void addAttributes(Model model){
        List<Employee> employees = employeeRepository.findAll();
        Collections.sort(employees,Comparator.comparing(Employee::getLastname).thenComparing(Employee::getFirstname));
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("chosenDept", new Department());
        model.addAttribute("employees", employees);
        model.addAttribute("employeeUtil", new EmployeeUtil());
    }


    @GetMapping()
    public String showDepartments(Model model, @ModelAttribute("chosenDept") Department chosenDept, @ModelAttribute("departments") List<Department> departments){
        String chosenDeptNo = chosenDept.getDeptNo();
        departments = departmentRepository.findAll();
        if(chosenDeptNo != null){
            final Department dept = departmentRepository.findById(chosenDeptNo).get();
            if(dept != null){
                List<Employee> employees = employeeRepository.findAll();
                Collections.sort(employees,Comparator.comparing(Employee::getLastname).thenComparing(Employee::getFirstname));

                System.out.println(employees.get(0).getDepartment());
                employees = employees.stream().filter(e -> e.getDepartment().equals(dept)).collect(Collectors.toList());
                model.addAttribute("employees", employees);
                chosenDept = dept;
                departments.remove(chosenDept);
            }
        }

        return "listView";
    }

    @PostMapping()
    public String removeEmployee(Model model, @ModelAttribute("employeeUtil") EmployeeUtil employeeUtil){
        for (Integer empNo: employeeUtil.getToRemove()) {
            Employee e = employeeRepository.findById(empNo).get();
            e.setDepartment(null);
        }
        return "listView";
    }
}
