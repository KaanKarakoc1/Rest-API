package com.example.demo.model.response;

import com.example.demo.model.dto.DepartmentDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class GetAllDepartmentsResponse {
    private List<DepartmentDto> departmentList;
    private String result;
}
