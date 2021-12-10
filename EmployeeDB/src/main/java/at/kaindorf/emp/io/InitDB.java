package at.kaindorf.emp.io;

import at.kaindorf.emp.pojos.Department;
import at.kaindorf.emp.pojos.Employee;
import at.kaindorf.emp.pojos.Gender;
import at.kaindorf.emp.repo.DepartmentRepository;
import at.kaindorf.emp.repo.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

/*
    Created by: Jonas Seidl
    Date: 26.11.2021
    Time: 10:45
*/
@Slf4j
@Component
public class InitDB {

    private Path filepath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "employees.json");

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void init() {
        log.info("INIT DB");
        System.out.println(filepath.toAbsolutePath().toString());
        try {
            List<Department> departments = getDepartments();
            departmentRepository.saveAll(departments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Department> getDepartments() throws IOException {
        List<Department> departments;
        ObjectMapper om = new ObjectMapper();
        departments = new ArrayList<>(Arrays.asList(om.readValue(filepath.toFile(), Department[].class)));


        Set<Department> uniqueDepartments = new HashSet<>();
        Set<Employee> uniqueEmployees = new HashSet<>();
        for (Department d: departments) {
            uniqueDepartments.add(d);
            for (Employee employee: d.getEmployees()) {
                uniqueEmployees.add(employee);
            }
        }

        for (Department d: uniqueDepartments) {
            List<Employee> employees = new ArrayList<>();
            for (Employee e: d.getEmployees()) {
                Employee unique = null;
                for (Employee ue: uniqueEmployees) {
                    if(e.getEmployeeNo() == ue.getEmployeeNo()) {
                        unique = ue;
                        unique.setDepartment(d);
                        break;
                    }
                }
                employees.add(unique);
            }
            d.setEmployees(employees);

            d.getDeptManager().setDepartment(d);
        }

        return new ArrayList<>(departments);
    }
}
