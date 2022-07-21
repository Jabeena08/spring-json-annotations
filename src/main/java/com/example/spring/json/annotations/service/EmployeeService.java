package com.example.spring.json.annotations.service;

import com.example.spring.json.annotations.dto.QueryResponse;
import com.example.spring.json.annotations.entity.Employee;
import com.example.spring.json.annotations.environment.Environment;
import com.example.spring.json.annotations.repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService
{

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee)
    {

        employee.setAccNo(UUID.randomUUID().toString());
        employee.setCompany("Infosys");
        return employeeRepository.save(employee);
    }

    public List<Employee> retrieveEmployees()
    {
        return employeeRepository.findAll();
    }

    public Employee retrieveEmployeeById(int id)
    {
        return employeeRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("EMPLOYEE WITH ID:"+id+" NOT FOUND"));
    }

    public void deleteEmployee(int id)
    {
            employeeRepository.deleteById(id);
    }

    public List<QueryResponse> retrieveQuery1(double salary)
    {
        return employeeRepository.retrieveQuery1(salary);
    }

    public List<QueryResponse> retrieveQuery2(double salary)
    {
        return employeeRepository.retrieveQuery2(salary);
    }
}

