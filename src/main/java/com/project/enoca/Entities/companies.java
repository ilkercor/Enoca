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
@Entity(name = "companies")
@Table(name = "companies")
public class companies {

    @Column(name = "company_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int company_id;


    @Column(name = "company_name")
    private String company_name;

}

