package com.project.job_board.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.job_board.Entity.Job;

// Interface extending JpaRepository for Job entity, with Long as the type of the primary key
public interface JobRepository extends JpaRepository<Job, Long>{

  // Custom query method to find a job by title
  Job findByTitle(String title);

  // Custom query method to find jobs by employer ID
  List<Job> findByEmployerId(Long Id);

}
