package com.tulu.jobms.job;

import org.springframework.data.jpa.repository.JpaRepository;
// crud repo has basic functionalities
// jpa repo extends it
//import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}
