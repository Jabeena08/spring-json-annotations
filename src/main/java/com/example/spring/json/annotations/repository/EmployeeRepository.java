package com.example.spring.json.annotations.repository;

import com.example.spring.json.annotations.dto.QueryResponse;
import com.example.spring.json.annotations.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
    @Query("select new com.example.spring.json.annotations.dto.QueryResponse(e.id,e.name,e.salary) from Employee e where e.salary> :salary")
    public List<QueryResponse> retrieveQuery1(@Param("salary") double salary);

    @Query("select new com.example.spring.json.annotations.dto.QueryResponse(e.id,e.name,e.salary,e.dept) from Employee e where e.salary<= :salary")
    public List<QueryResponse> retrieveQuery2(@Param("salary") double salary);
}
