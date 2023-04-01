package com.project.enoca.DataAccess.Company;

import com.project.enoca.Entities.companies;

import java.util.List;

public interface CompanyDAL {

    List<companies> getAll();
    String add(companies companies);
    String update(companies companies);
    String delete(companies companies);
    companies getById(int id);
}
