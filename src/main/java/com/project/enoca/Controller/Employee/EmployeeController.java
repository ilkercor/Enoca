package com.project.enoca.Controller.Employee;

import com.project.enoca.Entities.employees;
import com.project.enoca.Service.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public List<employees> get(){
        return employeeService.getAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody employees employee){
        return employeeService.add(employee);
    }

    @PostMapping("/update")
    public String update(@RequestBody employees employee){
        return employeeService.update(employee);
    }

    @PostMapping("/delete")
    public String delete(@RequestBody employees employee){
        return employeeService.delete(employee);
    }

    @GetMapping("/id={id}")
    public employees getByID(@PathVariable int id){
        return employeeService.getById(id);
    }



}
