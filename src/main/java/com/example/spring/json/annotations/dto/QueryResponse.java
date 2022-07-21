package com.example.spring.json.annotations.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
//It will display only non-default values
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class QueryResponse
{
    private int id;
    private String name;
    private String gender;
    private int age;
    private double salary;
    private String dept;
    private String email;
    private String company;
    private String accNo;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date joinDate;

    public  QueryResponse(int id,String name,double salary)
    {
        this.id=id;
        this.name=name;
        this.salary=salary;
    }
    public  QueryResponse(int id,String name,double salary,String dept)
    {
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.dept=dept;
    }
}

