package com.example.demo.controller;

import com.example.demo.model.request.CreateDepartmentRequest;
import com.example.demo.model.request.DeleteDepartmentRequest;
import com.example.demo.model.request.UpdateDepartmentRequest;
import com.example.demo.model.response.*;
import com.example.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("")
    public CreateDepartmentResponse saveDepartment(@RequestBody CreateDepartmentRequest department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("")
    public GetAllDepartmentsResponse getAllDepartmentList() {
        return departmentService.getAllDepartmentList();
    }

    @GetMapping("/{id}")
    public GetDepartmentResponse getDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @PutMapping("/{id}")
    public UpdateDepartmentResponse updateDepartment(@RequestBody UpdateDepartmentRequest department, @PathVariable("id") Long departmentId) {
        return departmentService.updateDepartment(department,departmentId);
    }

    @DeleteMapping("/{id}")
    public DeleteDepartmentResponse deleteDepartmentById(DeleteDepartmentRequest department, @PathVariable("id") Long departmentId) {
       return departmentService.deleteDepartmentById(department,departmentId);
    }
}
