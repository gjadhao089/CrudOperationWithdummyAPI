package com.demo.api.service.impl;

import com.demo.api.bean.Employee;
import com.demo.api.service.EmployeeService;
import com.demo.api.util.RestApiUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  RestApiUtil restApiUtil;

  @Override
  public List<Employee> getAllEmployee() {
    return restApiUtil.getAllEmployee();
  }

  @Override
  public Employee getEmployee(Integer empId) {
    return restApiUtil.getEmployeeById(empId);
  }

  @Override
  public Employee createEmployee(Employee employee) {
    return restApiUtil.createEmployee(employee);
  }

  @Override
  public Employee updateEmployee(Employee employee) {
    return restApiUtil.updateEmployee(employee);
  }

  @Override
  public void deleteEmployee(Integer empId) {
      restApiUtil.deleteEmployee(empId);
  }

}
