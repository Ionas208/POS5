package at.kaindorf.plf.controller;

import at.kaindorf.plf.pojos.Department;
import at.kaindorf.plf.pojos.Employee;
import at.kaindorf.plf.pojos.Salgrade;
import at.kaindorf.plf.pojos.Util;
import at.kaindorf.plf.repo.DepartmentRepository;
import at.kaindorf.plf.repo.EmployeeRepository;
import at.kaindorf.plf.repo.SalgradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/*
    Created by: Jonas Seidl
    Date: 27.01.2022
    Time: 11:53
*/
@Controller
@RequestMapping("/scottdb")
@SessionAttributes({"departments", "util", "employeeRepository", "salgradeRepository", "emp2Insert"})
public class ScottController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SalgradeRepository salgradeRepository;


    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("employeeRepository", employeeRepository);
        model.addAttribute("salgradeRepository", salgradeRepository);
        model.addAttribute("emp2Insert", new Employee());
        model.addAttribute("util", new Util());
    }

    @GetMapping
    public String getDept(){
        return "scottView";
    }

    @PostMapping
    public String selectDept(Model model, @ModelAttribute("util") Util util){
        Department d = departmentRepository.findById(util.getChosenDeptNo()).get();
        //Map<Employee, Salgrade> empSalMap = employeeRepository.findAllWithSalgrade();
        List<Employee> emps = employeeRepository.findAllByDept(d);
        model.addAttribute("employees", emps);
        return "scottView";
    }

    @PostMapping("/addEmp")
    public String addEmployee(Model model, @ModelAttribute("util") Util util, @Valid @ModelAttribute("emp2Insert") Employee emp2Insert, Errors errors){
        Department d = departmentRepository.findById(util.getChosenDeptNo()).get();
        if(errors.hasErrors()){
            List<Employee> emps = employeeRepository.findAllByDept(d);
            model.addAttribute("employees", emps);
            return "scottView";
        }

        Integer newEmpno = employeeRepository.findMaxEmpno() + 1;
        emp2Insert.setEmpno(newEmpno);
        emp2Insert.setDept(d);

        employeeRepository.save(emp2Insert);

        List<Employee> emps = employeeRepository.findAllByDept(d);
        model.addAttribute("employees", emps);

        return "scottView";
    }
}
