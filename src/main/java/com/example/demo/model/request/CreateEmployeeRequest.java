package com.example.demo.model.request;

import com.example.demo.entity.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmployeeRequest {

    private Department department;

    private String firstName;

    private String lastName;

    private String address;

    private String email;
}
