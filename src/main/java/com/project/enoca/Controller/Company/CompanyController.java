package com.project.enoca.Controller.Company;

import com.project.enoca.Entities.companies;
import com.project.enoca.Service.Company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {


    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/list")
    public List<companies> get(){
        return companyService.getAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody companies companies){
        return companyService.add(companies);
    }

    @PostMapping("/update")
    public String update(@RequestBody companies companies){
        return companyService.update(companies);
    }

    @PostMapping("/delete")
    public String delete(@RequestBody companies companies){
        return companyService.delete(companies);
    }

    @GetMapping("/id={id}")
    public companies getByID(@PathVariable int id){
        return companyService.getById(id);
    }

}
