package com.tulu.jobms.job;

import com.tulu.jobms.job.dto.JobWithCompanyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// here using request mapping we are telling that /jobs is the base url and every method is based on it.
// if we don't use it then after each mapping we have to add /jobs
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobWithCompanyDTO>> findall(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return ResponseEntity.ok("Job added successfully");
    }

    @GetMapping("/{id}")
    public  ResponseEntity<JobWithCompanyDTO> getJobId(@PathVariable Long id){
        JobWithCompanyDTO jobWithCompanyDTO = jobService.getJobById(id);
        if(jobWithCompanyDTO != null)
            return new ResponseEntity<>(jobWithCompanyDTO, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        if(jobService.deleteJobById(id))
            return ResponseEntity.ok("Job deleted");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    //below is another version of put request mapping, we can whichever we prefer
//    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job updatedJob){
        if(jobService.updateJobById(id, updatedJob)){
            return new ResponseEntity<>("Job updated", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
