package com.project.enoca.DataAccess.Employee;
import com.project.enoca.Entities.employees;

import java.util.List;

public interface EmployeeDAL {
    List<employees> getAll();
    String add(employees employee);
    String update(employees employee);
    String delete(employees employee);
    employees getById(int id);
}
