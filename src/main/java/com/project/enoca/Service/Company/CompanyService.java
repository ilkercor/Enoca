package com.project.enoca.Service.Company;

import com.project.enoca.Entities.companies;

import java.util.List;

public interface CompanyService {

    List<companies> getAll();
    String add(companies companies);
    String update(companies companies);
    String delete(companies companies);
    companies getById(int id);
}
