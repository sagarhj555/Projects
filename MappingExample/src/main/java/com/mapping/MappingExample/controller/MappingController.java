package com.mapping.MappingExample.controller;

import com.mapping.MappingExample.entity.Employee;
import com.mapping.MappingExample.repository.AddressRepo;
import com.mapping.MappingExample.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MappingController {

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/")
    public String test(){
        return "Hello";
    }

    @PostMapping("/saveall")
    public List<Employee> saveEmployees(@RequestBody List<Employee> employee){
        return employeeRepo.saveAll(employee);
    }

    @GetMapping("/getall")
    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        employeeRepo.deleteById(id);
        return "Deleted";
    }
}
