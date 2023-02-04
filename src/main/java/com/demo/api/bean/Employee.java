package com.demo.api.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
  private Integer id;
  private String employee_name;
  private Integer employee_salary;
  private Integer employee_age;
  private String profile_image;
}
