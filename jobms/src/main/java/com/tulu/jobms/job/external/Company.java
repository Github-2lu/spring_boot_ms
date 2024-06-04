package com.tulu.jobms.job.external;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Company {
    private Long id;
    private String name;
    private String description;

    // means in Job table there is a column named company which stores all company data
    // if we don't mention this. it will create 3 tables

    // private List<Review> reviews;


    public Company(Long id, String name, String desc){
        this.id = id;
        this.name = name;
        this.description = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

