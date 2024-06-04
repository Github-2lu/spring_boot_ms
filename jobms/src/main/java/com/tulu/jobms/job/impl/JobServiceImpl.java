package com.tulu.jobms.job.impl;

import com.tulu.jobms.job.Job;
import com.tulu.jobms.job.JobRepository;
import com.tulu.jobms.job.JobService;
import com.tulu.jobms.job.clients.CompanyClient;
import com.tulu.jobms.job.clients.ReviewClient;
import com.tulu.jobms.job.dto.JobDTO;
import com.tulu.jobms.job.external.Company;
import com.tulu.jobms.job.external.Review;
import com.tulu.jobms.job.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    final private CompanyClient companyClient;
    final private ReviewClient reviewClient;

    public JobServiceImpl(JobRepository jobRepository, CompanyClient companyClient, ReviewClient reviewClient){
        this.jobRepository = jobRepository;
        this.companyClient = companyClient;
        this.reviewClient = reviewClient;
    }

    private JobDTO convertToDTO(Job job){
        //RestTemplate restTemplate = new RestTemplate();

        // when using eureka server registry we don't have to use server ip address. We can use application name
        // but we can't use simple restTemplate it has to be load balanced
        Company company = companyClient.getCompany(job.getCompanyId());

        List<Review> reviews = reviewClient.getReviews(job.getCompanyId());

        return JobMapper.mapToJobWithCompanyDTO(job, company, reviews);
    }

    public List<JobDTO> findAll() {
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

    public JobDTO getJobById(Long id){
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
