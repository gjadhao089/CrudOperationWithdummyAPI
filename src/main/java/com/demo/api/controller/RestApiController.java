package com.demo.api.controller;

import com.demo.api.bean.Employee;
import com.demo.api.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class RestApiController {

  @Autowired
  EmployeeService employeeService;

  @GetMapping("/")
  public ResponseEntity<List<Employee>> getAllEmployee() {

    return ResponseEntity.ok(this.employeeService.getAllEmployee());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer empId) {

    return ResponseEntity.ok(this.employeeService.getEmployee(empId));
  }

  @PostMapping("/")
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

    return ResponseEntity.ok(this.employeeService.createEmployee(employee));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer empId, @RequestBody Employee employee) {
    if (empId != null && empId == employee.getId()) {
      return ResponseEntity.ok(this.employeeService.updateEmployee(employee));
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteEmployee(@PathVariable("id") Integer empId) {
      this.employeeService.deleteEmployee(empId);
    return ResponseEntity.ok().build();
  }

}
