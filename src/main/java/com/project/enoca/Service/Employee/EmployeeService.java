package com.project.enoca.Service.Employee;

import com.project.enoca.Entities.employees;

import java.util.List;

public interface EmployeeService {
    List<employees> getAll();
    String add(employees employee);
    String update(employees employee);
    String delete(employees employee);
    employees getById(int id);
}
