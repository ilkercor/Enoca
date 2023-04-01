package com.project.enoca.DataAccess.Company.impl;

import com.project.enoca.DataAccess.Company.CompanyDAL;
import com.project.enoca.Entities.companies;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CompanyDALImpl implements CompanyDAL {

    private EntityManager entityManager;

    @Autowired
    public CompanyDALImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public CompanyDALImpl() {
    }


    @Override
    @Transactional
    public List<companies> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<companies> companyList = session.createQuery("from companies", com.project.enoca.Entities.companies.class).getResultList();
        return companyList;
    }

    @Override
    @Transactional
    public String add(companies company) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(company);
        return company.getCompany_name()+ " is saved to Database ";
    }

    @Override
    @Transactional
    public String update(companies company) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(company);
        return company.getCompany_name()+" is updated.";
    }

    @Override
    @Transactional
    public String delete(companies company) {
        Session session = entityManager.unwrap(Session.class);
        companies companyToDelete = session.get(companies.class, company.getCompany_id());
        session.delete(companyToDelete);
        return companyToDelete.getCompany_name()+" is deleted.";
    }

    @Override
    public companies getById(int id) {
        Session session =  entityManager.unwrap(Session.class);
        companies company = session.get(companies.class, id);
        return company;
    }
}
