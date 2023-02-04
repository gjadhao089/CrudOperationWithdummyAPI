package com.demo.api.service;

import com.demo.api.bean.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployee(Integer empId);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Integer empId);

}
