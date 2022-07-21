package com.example.spring.json.annotations.environment;

import com.fasterxml.jackson.annotation.JsonTypeName;


@JsonTypeName("qa")
public class QualityAssurance extends Environment
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

}
