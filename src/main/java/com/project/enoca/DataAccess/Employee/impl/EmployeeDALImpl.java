package com.project.enoca.DataAccess.Employee.impl;

import com.project.enoca.DataAccess.Employee.EmployeeDAL;
import com.project.enoca.Entities.companies;
import com.project.enoca.Entities.employees;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDALImpl implements EmployeeDAL {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDALImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public EmployeeDALImpl() {
    }


    @Override
    @Transactional
    public List<employees> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<employees> employeesList = session.createQuery("from employees", com.project.enoca.Entities.employees.class).getResultList();
        return employeesList;
    }

    @Override
    @Transactional
    public String add(employees employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
        return employee.getEmployee_name()+" "+employee.getEmployee_lastname()+ " is saved to Database ";
    }

    @Override
    @Transactional
    public String update(employees employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
        return employee.getEmployee_name()+" "+employee.getEmployee_lastname()+" is updated.";
    }

    @Override
    @Transactional
    public String delete(employees employee) {
        Session session = entityManager.unwrap(Session.class);
        employees employeeToDelete = session.get(employees.class, employee.getEmployee_id());
        session.delete(employeeToDelete);
        return employeeToDelete.getEmployee_name()+" "+employeeToDelete.getEmployee_lastname()+" is deleted.";
    }

    @Override
    @Transactional
    public employees getById(int id) {
        Session session =  entityManager.unwrap(Session.class);
        employees employee = session.get(employees.class, id);
        return employee;
    }
}
