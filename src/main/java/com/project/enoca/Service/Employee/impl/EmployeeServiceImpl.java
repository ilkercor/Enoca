package com.project.enoca.Service.Employee.impl;

import com.project.enoca.DataAccess.Employee.EmployeeDAL;
import com.project.enoca.Entities.employees;
import com.project.enoca.Service.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAL employeeDAL;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAL employeeDAL){
        this.employeeDAL = employeeDAL;
    }

    @Override
    @Transactional
    public List<employees> getAll() {
        return this.employeeDAL.getAll();
    }

    @Override
    @Transactional
    public String add(employees employee) {
        return this.employeeDAL.add(employee);
    }

    @Override
    @Transactional
    public String update(employees employee) {
        return this.employeeDAL.update(employee);
    }

    @Override
    @Transactional
    public String delete(employees employee) {
        return this.employeeDAL.delete(employee);
    }

    @Override
    @Transactional
    public employees getById(int id) {
        return this.employeeDAL.getById(id);
    }
}
