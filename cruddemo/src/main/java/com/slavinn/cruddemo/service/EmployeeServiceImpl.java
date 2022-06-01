package com.slavinn.cruddemo.service;


import com.slavinn.cruddemo.dao.EmployeeDAO;
import com.slavinn.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    @Override
    @Transactional
    public Employee getEmployee(int theId) {
        return employeeDAO.getEmployee(theId);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee theEmployee) {
        employeeDAO.updateEmployee(theEmployee);
    }

    @Override
    @Transactional
    public void createEmployee(Employee theEmployee) {
        employeeDAO.createEmployee(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {

    }
}
