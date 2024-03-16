package com.example.demo.service;

import com.example.demo.model.request.CreateEmployeeRequest;
import com.example.demo.model.request.DeleteEmployeeRequest;
import com.example.demo.model.request.UpdateEmployeeRequest;
import com.example.demo.model.response.*;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

 CreateEmployeeResponse saveEmployee(CreateEmployeeRequest employee);
 DeleteEmployeeResponse deleteEmployeeById(DeleteEmployeeRequest department, Long employeeId);
 GetAllEmployeeResponse getAllEmployeeList();
 GetEmployeeResponse getEmployeeById(Long employeeId);
 UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest employee, Long employeeId);
}
