package com.example.lab3_20215433.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;

@Getter
@Setter
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstname;

    @Column(name = "last_name", nullable = false)
    private String lastname;

    @Column(name = "phone_number", nullable = false)
    private String phone_number;

    @Column(name = "salary", nullable = false)
    private String salary;

    @Column(name = "job_id", nullable = false)
    private String job_id;

    @Column(name = "hire_date", nullable = false)
    private String hire_date;

//CARGO -> JOB ID
//DEPARTAMENTO -> DEPARTMENT ID



}
