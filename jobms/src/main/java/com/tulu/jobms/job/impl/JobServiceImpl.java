package com.tulu.jobms.job.impl;

import com.tulu.jobms.job.Job;
import com.tulu.jobms.job.JobRepository;
import com.tulu.jobms.job.JobService;
import com.tulu.jobms.job.dto.JobWithCompanyDTO;
import com.tulu.jobms.job.external.Company;
import com.tulu.jobms.job.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// this acts as the implementation of all the services
@Service
public class JobServiceImpl implements JobService {
//    private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;
//    private Long id=1L;

    @Autowired
    // auto wired is used to provide resTemplate on runtime. It is possible as we use bean in AppConfig
    RestTemplate restTemplate;

    public JobServiceImpl(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    private JobWithCompanyDTO convertToDTO(Job job){
        //RestTemplate restTemplate = new RestTemplate();

        // when using eureka server registry we don't have to use server ip address. We can use application name
        // but we can't use simple restTemplate it has to be load balanced
        Company company = restTemplate.getForObject("http://COMPANYMS:8081/companies/" + job.getCompanyId(), Company.class);

        JobWithCompanyDTO jobWithCompanyDTO = JobMapper.mapToJobWithCompanyDTO(job, company);

        return jobWithCompanyDTO;

    }

    public List<JobWithCompanyDTO> findAll() {
        // DTO is used to create custom response
        List<Job> jobs = jobRepository.findAll();
        // here rest template is used to communicate between two microservices using rest api calls

        return jobs.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void createJob(Job job) {
//        job.setId(id++);
        jobRepository.save(job);
    }

    public JobWithCompanyDTO getJobById(Long id){
        Job job =  jobRepository.findById(id).orElse(null);
        return convertToDTO(job);
    }

    public boolean deleteJobById(Long id){
        try {
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean updateJobById(Long id, Job updatedJob){
        Optional<Job> jobOptional = jobRepository.findById(id);

            if(jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setLocation(updatedJob.getLocation());
                job.setMaxSal(updatedJob.getMaxSal());
                job.setMinSal(updatedJob.getMinSal());
                jobRepository.save(job);
                return true;
            }
        return false;
    }
}
