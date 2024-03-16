package com.example.demo.controller;

import com.example.demo.model.request.CreateEmployeeRequest;
import com.example.demo.model.request.DeleteEmployeeRequest;
import com.example.demo.model.request.UpdateEmployeeRequest;
import com.example.demo.model.response.*;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping()
    public CreateEmployeeResponse saveEmployee(@RequestBody CreateEmployeeRequest employee){
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public DeleteEmployeeResponse deleteEmployeeById(DeleteEmployeeRequest employee,@PathVariable("id") Long employeeId){
        return employeeService.deleteEmployeeById(employee,employeeId);
    }
    @GetMapping("")
    public GetAllEmployeeResponse getAllEmployeeList() {
        return employeeService.getAllEmployeeList();
    }

    @GetMapping("/{id}")
    public GetEmployeeResponse getEmployeeList(@PathVariable("id") Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }
    @PutMapping("/{id}")
    public UpdateEmployeeResponse updateEmployee(@RequestBody UpdateEmployeeRequest employee, @PathVariable("id") Long employeeId){
     return employeeService.updateEmployee(employee,employeeId);}

}
