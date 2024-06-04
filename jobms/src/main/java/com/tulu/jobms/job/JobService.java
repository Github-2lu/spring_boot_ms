package com.tulu.jobms.job;

import com.tulu.jobms.job.dto.JobDTO;

import java.util.List;

// this acts as an interface for all functionalities
public interface JobService {
    List<JobDTO> findAll();
    void createJob(Job job);
    JobDTO getJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updateJobById(Long id, Job job);
}
