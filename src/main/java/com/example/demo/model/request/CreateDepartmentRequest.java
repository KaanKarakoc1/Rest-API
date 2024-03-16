package com.example.demo.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDepartmentRequest {

        private String departmentName;
        private String departmentAddress;
        private String departmentCode;
}
