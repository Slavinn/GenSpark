package com.slavinn.cruddemo.service;

import com.slavinn.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployees();

    public Employee getEmployee(int theId);

    public void updateEmployee(Employee theEmployee);

    public void createEmployee(Employee theEmployee);

    public void deleteById(int theId);

}
