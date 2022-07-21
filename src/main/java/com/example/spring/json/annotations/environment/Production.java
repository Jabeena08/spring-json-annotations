package com.example.spring.json.annotations.environment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Embeddable;


@JsonTypeName("prod")
@Data
public class Production extends Environment
{

    @Override
    public String getEnvironment() {
        return super.getEnvironment();
    }

    @Override
    public String getManager() {
        return super.getManager();
    }

    @Override
    public void setEnvironment(String environment) {
        super.setEnvironment(environment);
    }

    @Override
    public void setManager(String manager) {
        super.setManager(manager);
    }

    @Override
    public String toString() {
        return "Environment{" +
                "environment='" + super.getEnvironment() + '\'' +
                ", manager='" + super.getManager() + '\'' + "no_of_cycles='"+super.getNo_of_cycles()+
                '}';
    }

}
