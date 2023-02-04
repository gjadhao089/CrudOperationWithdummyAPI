package com.demo.api.util;


import com.demo.api.bean.Employee;
import com.demo.api.bean.EmployeeListResponse;
import com.demo.api.bean.EmployeeResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestApiUtil {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${url}")
  private String url;

  public List<Employee> getAllEmployee(){
    try{
      return (List<Employee>) restTemplate.getForObject(url+"/employees", EmployeeListResponse.class).getData();
    }catch (Exception e){
      return null;
    }

  }

  public Employee getEmployeeById(Integer id){
    try{
      return restTemplate.getForObject(url+"/employee/"+id, EmployeeResponse.class).getData();
    }catch (Exception e){
      return null;
    }

  }

  public Employee createEmployee(Employee employee){
    HttpHeaders headers =  new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Employee> request= new HttpEntity<>(employee, headers);
    try{
      return restTemplate.postForObject(url+"/create",request, EmployeeResponse.class).getData();
    }catch (Exception e){
      return null;
    }

  }

  public Employee updateEmployee(Employee employee){
    HttpHeaders headers =  new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Employee> request= new HttpEntity<>(employee, headers);
    try{
      return restTemplate.exchange(url+"/update/"+employee.getId(), HttpMethod.PUT, request, EmployeeResponse.class).getBody()
          .getData();
    }catch (Exception e){
      return null;
    }

  }

  public void deleteEmployee(Integer id){
    try{
      restTemplate.delete(url+"/delete/"+id);
    }catch (Exception e){
      
    }

  }
}
