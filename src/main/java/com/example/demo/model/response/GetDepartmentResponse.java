package com.example.demo.model.response;

import com.example.demo.model.dto.DepartmentDto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GetDepartmentResponse {

    private DepartmentDto departmentDto;

    private String result;

}
