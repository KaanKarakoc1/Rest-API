package com.example.demo.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDepartmentRequest {

    private Long id;

    private String departmentName;

    private String departmentAddress;

    private String departmentCode;
}

