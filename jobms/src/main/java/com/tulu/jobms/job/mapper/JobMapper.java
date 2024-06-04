package com.tulu.jobms.job.mapper;

import com.tulu.jobms.job.Job;
import com.tulu.jobms.job.dto.JobDTO;
import com.tulu.jobms.job.external.Company;
import com.tulu.jobms.job.external.Review;

import java.util.List;

public class JobMapper {
    public static JobDTO mapToJobWithCompanyDTO(Job job, Company company, List<Review> reviews){
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setMinSal(job.getMinSal());
        jobDTO.setMaxSal(job.getMaxSal());
        jobDTO.setCompany(company);
        jobDTO.setReviews(reviews);

        return jobDTO;
    }
}
