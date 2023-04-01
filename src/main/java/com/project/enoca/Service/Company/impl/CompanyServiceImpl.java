package com.project.enoca.Service.Company.impl;

import com.project.enoca.DataAccess.Company.CompanyDAL;
import com.project.enoca.Entities.companies;
import com.project.enoca.Service.Company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyDAL companyDal;

    @Autowired
    public CompanyServiceImpl(CompanyDAL companyDal) {
        this.companyDal = companyDal;
    }

    @Override
    @Transactional
    public List<companies> getAll() {
        return this.companyDal.getAll();
    }

    @Override
    @Transactional
    public String add(companies companies) {
        return this.companyDal.add(companies);
    }

    @Override
    @Transactional
    public String update(companies companies) {
        return this.companyDal.update(companies);
    }

    @Override
    @Transactional
    public String delete(companies companies) {
        return this.companyDal.delete(companies);
    }

    @Override
    public companies getById(int id) {
        return this.companyDal.getById(id);
    }


}
