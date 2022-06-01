package com.slavinn.cruddemo.rest;


import com.slavinn.cruddemo.dao.EmployeeDAO;
import com.slavinn.cruddemo.entity.Employee;
import com.slavinn.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployees(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.getEmployee(employeeId);

        if(theEmployee == null) {
            throw new RuntimeException("Employee id was not found - " + employeeId);
        }

        return theEmployee;
    }

    @PutMapping("/employees")
    public String updateEmployee(@RequestBody Employee theEmployee) {
        employeeService.updateEmployee(theEmployee);
        return "Updated Employee - " + theEmployee;
    }

    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employee theEmployee) {

        theEmployee.setId(0);
        employeeService.createEmployee(theEmployee);


        return "Created Employee - " + theEmployee;
    }
}
