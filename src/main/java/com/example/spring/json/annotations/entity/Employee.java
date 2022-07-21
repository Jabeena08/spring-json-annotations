package com.example.spring.json.annotations.entity;

import com.example.spring.json.annotations.environment.Environment;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="employee_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(
        {
        "id","name","gender","age","dept","salary",
        "email","joinDate","isBillable","company","technologies","environment","address"
        }
                   )
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value="employeeId")
    private int id;

    @JsonProperty(value ="employeeName")
    @JsonAlias({"empName","eName"})
    private String name;

    private String gender;

    @JsonAlias("empAge")
    private int age;

    @JsonAlias("empSalary")
    private double salary;

    private String dept;

    private String email;

    private boolean isBillable;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String company;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String accNo;

    @JsonFormat(pattern ="dd-MM-yyyy",shape = JsonFormat.Shape.STRING)
    @Temporal(TemporalType.DATE)
    private Date joinDate;


    @ElementCollection
    @CollectionTable(name = "emp_address_mapping",
            joinColumns = {@JoinColumn(name = "employeeId", referencedColumnName = "id")})
    @MapKeyColumn(name = "address_name")
    @Column(name="address_value")
    private Map<String,String> address=new HashMap<>();



    @Convert(converter=ListToStringConverter.class)
    private List<String> technologies;

    @Embedded
    private Environment environment;

    @JsonSetter("isBillable")
    public void setBillable(boolean isBillable)
    {
        this.isBillable=isBillable;
    }


    @JsonAnyGetter
    public Map<String,String> getAddress()
    {
        return address;
    }

    @JsonAnySetter
    public void setAddress(String key,String value)
    {
       this.address.put(key,value);
    }

}

