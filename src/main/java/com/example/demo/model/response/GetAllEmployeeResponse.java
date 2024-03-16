package com.example.demo.model.response;


import com.example.demo.model.dto.EmployeeDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllEmployeeResponse {
    private List<EmployeeDto> employeeList;
    private String result;
}
