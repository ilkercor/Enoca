package com.project.enoca.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employees")
@Table(name = "employees")
public class employees {

    @Column(name = "employee_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    @Column(name = "company_id")
    private int company_id;

    @Column(name = "employee_name")
    private String employee_name;

    @Column(name = "employee_lastname")
    private String employee_lastname;

}
