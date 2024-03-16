package com.example.demo.service;


import com.example.demo.entity.Employee;
import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.model.request.CreateEmployeeRequest;
import com.example.demo.model.request.DeleteEmployeeRequest;
import com.example.demo.model.request.UpdateEmployeeRequest;
import com.example.demo.model.response.*;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.exception.NoSuchEmployeeExistsException;
import com.example.demo.service.mapper.MapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final MapperService mapperService;
    @Override
    public CreateEmployeeResponse saveEmployee(CreateEmployeeRequest employeeDto){
        CreateEmployeeResponse response = new CreateEmployeeResponse();
        Employee employee = employeeRepository.save(mapperService.map(employeeDto,Employee.class));
            response.setResult("Employee added successfully");
            return response;
    }
    @Override
    public DeleteEmployeeResponse deleteEmployeeById(DeleteEmployeeRequest employee, Long employeeId){
        DeleteEmployeeResponse response = new DeleteEmployeeResponse();
        response.setResult("Deleted Successfully");
        employeeRepository.deleteById(employeeId);
        return response;
    }

    @Override
    public GetAllEmployeeResponse getAllEmployeeList(){
        GetAllEmployeeResponse response = new GetAllEmployeeResponse();
        List<EmployeeDto> employeeDtoList  = mapperService.mapList(employeeRepository.findAll(),EmployeeDto.class);
        if(employeeDtoList.isEmpty()){
            response.setResult("List is empty");
        } else {
            response.setResult("Successful");
            response.setEmployeeList(employeeDtoList);
        }
        return response;
    }
    @Override
    public GetEmployeeResponse getEmployeeById(Long employeeId){
        GetEmployeeResponse response = new GetEmployeeResponse();
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if (!employee.isPresent() ) {
            throw new NoSuchEmployeeExistsException("NO EMPLOYEE WITH ID = " + employeeId);
        } else {

            response.setResult("Successfully");
            response.setEmployeeDto(mapperService.map(employee.get(), EmployeeDto.class));
        }
        return response;
    }

    @Override
    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest employeeDto, Long employeeId){
        Employee employee = new Employee();
        UpdateEmployeeResponse response = new UpdateEmployeeResponse();

        Optional<Employee> existingEmployee = employeeRepository.findById(employeeId);
        if (!existingEmployee.isPresent() )
            throw new NoSuchEmployeeExistsException("No Such Employee exists!!");
        else {
            employee = existingEmployee.get();
            Employee updatedEmployee= mapperService.map(employeeDto, Employee.class);
            updatedEmployee.setId(employeeId);
            employeeRepository.save(updatedEmployee);
            response.setResult("Record updated Successfully");
        }
        return response;
    }
}
