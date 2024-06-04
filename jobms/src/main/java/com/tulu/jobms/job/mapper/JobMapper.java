package com.tulu.jobms.job.mapper;

import com.tulu.jobms.job.Job;
import com.tulu.jobms.job.dto.JobWithCompanyDTO;
import com.tulu.jobms.job.external.Company;

public class JobMapper {
    public static JobWithCompanyDTO mapToJobWithCompanyDTO(Job job, Company company){
        JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();
        jobWithCompanyDTO.setId(job.getId());
        jobWithCompanyDTO.setTitle(job.getTitle());
        jobWithCompanyDTO.setDescription(job.getDescription());
        jobWithCompanyDTO.setLocation(job.getLocation());
        jobWithCompanyDTO.setMinSal(job.getMinSal());
        jobWithCompanyDTO.setMaxSal(job.getMaxSal());
        jobWithCompanyDTO.setCompany(company);

        return jobWithCompanyDTO;
    }
}
