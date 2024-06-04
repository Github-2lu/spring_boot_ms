package com.tulu.jobms.job;

import com.tulu.jobms.job.dto.JobWithCompanyDTO;

import java.util.List;

// this acts as an interface for all functionalities
public interface JobService {
    List<JobWithCompanyDTO> findAll();
    void createJob(Job job);
    JobWithCompanyDTO getJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updateJobById(Long id, Job job);
}
