package com.example.demo.model.response;

import com.example.demo.model.dto.EmployeeDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetEmployeeResponse {

    private EmployeeDto employeeDto;

    private String result;
}
