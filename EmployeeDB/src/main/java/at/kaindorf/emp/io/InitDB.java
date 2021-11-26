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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        return departments;
    }
}
