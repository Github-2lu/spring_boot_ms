package com.tulu.jobms.job;
import jakarta.persistence.*;

// table annotation is used to change table name in DB
@Table(name = "job_table")
// entity annotation is used to get table entry from job values
@Entity
public class Job {
    // id is used to denote primary key
    @Id
    // used to auto generate values
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minSal;
    private String maxSal;
    private String location;
    private Long companyId;

    // default constructor needed to jpa work properly
    public Job(){}

    public Job(Long id, String title, String description, String minSal, String maxSal, String location){
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSal = minSal;
        this.maxSal = maxSal;
        this.location = location;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMinSal() {
        return minSal;
    }

    public void setMinSal(String minSal) {
        this.minSal = minSal;
    }

    public String getMaxSal() {
        return maxSal;
    }

    public void setMaxSal(String maxSal) {
        this.maxSal = maxSal;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
