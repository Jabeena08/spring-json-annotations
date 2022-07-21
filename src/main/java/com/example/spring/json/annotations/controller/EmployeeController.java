package com.example.spring.json.annotations.controller;

import com.example.spring.json.annotations.dto.QueryResponse;
import com.example.spring.json.annotations.entity.Employee;
import com.example.spring.json.annotations.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee)
    {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> retrieveEmployees()
    {
        return employeeService.retrieveEmployees();
    }

    @GetMapping("/{id}")
    public Employee retrieveEmployeeById(@PathVariable int id)
    {
        return employeeService.retrieveEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        employeeService.deleteEmployee(id);
        return "Employee Deleted with id:"+id;

    }

    @GetMapping("/query1/{salary}")
    public List<QueryResponse> retrieveQuery1(@PathVariable double salary)
    {
        return employeeService.retrieveQuery1(salary);
    }
    @GetMapping("/query2/{salary}")
    public List<QueryResponse> retrieveQuery2(@PathVariable double salary)
    {
        return employeeService.retrieveQuery2(salary);
    }
}
