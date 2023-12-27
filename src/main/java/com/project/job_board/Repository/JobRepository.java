package com.project.job_board.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.job_board.Entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

  Job findByTitle(String title);

  List<Job> findByEmployerId(Long Id);

}
