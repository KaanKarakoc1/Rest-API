package com.example.demo.service;


import com.example.demo.entity.Department;
import com.example.demo.model.dto.DepartmentDto;
import com.example.demo.model.request.CreateDepartmentRequest;
import com.example.demo.model.request.DeleteDepartmentRequest;
import com.example.demo.model.request.UpdateDepartmentRequest;
import com.example.demo.model.response.*;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.exception.NoSuchDepartmentExistsException;
import com.example.demo.service.mapper.MapperService;
import com.example.demo.utilities.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository departmentRepository;
    private final MapperService mapperService;


    @Override
    public CreateDepartmentResponse saveDepartment(CreateDepartmentRequest departmentDto){

       Department department = new Department();
        department = mapperService.map(departmentDto, Department.class);
        CreateDepartmentResponse response = new CreateDepartmentResponse();
        departmentRepository.save(department);
        response.setResult("Department added successfully");
        return response;
}

    @Override
    public UpdateDepartmentResponse updateDepartment(UpdateDepartmentRequest departmentDto, @PathVariable("id") Long departmentId) {

        Department department = new Department();
        UpdateDepartmentResponse response = new UpdateDepartmentResponse();

        Optional<Department> existingDepartment = departmentRepository.findById(departmentId);
        if (!existingDepartment.isPresent())
            throw new NoSuchDepartmentExistsException("No Such Department exists!!");
        else {
            department = existingDepartment.get();
            Department updatedDepartment = mapperService.map(departmentDto, Department.class);
            updatedDepartment.setId(departmentId);
            departmentRepository.save(updatedDepartment);
            response.setResult(StatusEnum.SUCCESS.getValue());
        }
        return response;
    }

    @Override
    public GetAllDepartmentsResponse getAllDepartmentList() {
        GetAllDepartmentsResponse response = new GetAllDepartmentsResponse();
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
            departmentDtoList =  mapperService.mapList(departmentRepository.findAll(), DepartmentDto.class);

        if(departmentDtoList.isEmpty()){
            response.setResult("List is empty");
        } else {
            response.setResult("Successful");
            response.setDepartmentList(departmentDtoList);
        }
        return response;
    }

    @Override
    public GetDepartmentResponse getDepartmentById(Long departmentId){
        GetDepartmentResponse response = new GetDepartmentResponse();
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto = mapperService.map(departmentRepository.findById(departmentId), DepartmentDto.class);

        if ( departmentDto ==null) {
            throw new NoSuchElementException("NO DEPARTMENT PRESENT WITH ID = " + departmentId);
        } else {
            response.setResult("Successfully");
            response.setDepartmentDto(departmentDto);
        }
        return response;
    }

    @Override
    public DeleteDepartmentResponse deleteDepartmentById(DeleteDepartmentRequest department, Long departmentId)
    {
        DeleteDepartmentResponse response = new DeleteDepartmentResponse();
        response.setResult("Deleted Successfully");
        departmentRepository.deleteById(departmentId);
        return response;
    }


}