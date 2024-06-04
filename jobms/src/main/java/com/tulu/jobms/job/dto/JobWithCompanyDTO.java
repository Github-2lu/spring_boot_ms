package com.tulu.jobms.job.dto;

import com.tulu.jobms.job.Job;
import com.tulu.jobms.job.external.Company;

public class JobWithCompanyDTO {
    private Long id;
    private String title;
    private String description;
    private String minSal;
    private String maxSal;
    private String location;
    private Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
