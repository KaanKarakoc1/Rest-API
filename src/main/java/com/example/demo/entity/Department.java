package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employeeList"})
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "department_id")
    private Long id;
    @Column
    private String departmentName;
    @Column
    private String departmentAddress;
    @Column
    private String departmentCode;
    @OneToMany(mappedBy ="department")
    private List<Employee> employeeList;
}