package com.tulu.companyms.company;
import jakarta.persistence.*;

@Entity
@Table(name = "company_table")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    // means in Job table there is a column named company which stores all company data
    // if we don't mention this. it will create 3 tables

    // private List<Review> reviews;

    // for jpa to work it is needed
    public Company(){}

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
