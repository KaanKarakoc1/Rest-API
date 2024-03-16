package com.example.demo.service;

import com.example.demo.model.request.CreateDepartmentRequest;
import com.example.demo.model.request.DeleteDepartmentRequest;
import com.example.demo.model.request.UpdateDepartmentRequest;
import com.example.demo.model.response.*;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {

     CreateDepartmentResponse saveDepartment(CreateDepartmentRequest department);


    GetAllDepartmentsResponse getAllDepartmentList();//get

    GetDepartmentResponse getDepartmentById(Long departmentId);

    UpdateDepartmentResponse updateDepartment(UpdateDepartmentRequest department, Long departmentId);

    DeleteDepartmentResponse deleteDepartmentById(DeleteDepartmentRequest department, Long departmentId);


}
