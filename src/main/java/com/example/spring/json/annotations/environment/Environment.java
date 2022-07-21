package com.example.spring.json.annotations.environment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property ="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Production.class, name = "prod"),
        @JsonSubTypes.Type(value = Development.class, name = "dev"),
        @JsonSubTypes.Type(value = QualityAssurance.class, name = "qa")
              })
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public  class Environment
{
    private String environment;
    private String manager;
    private String no_of_cycles;

}
