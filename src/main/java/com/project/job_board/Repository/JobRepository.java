package com.project.job_board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.job_board.Entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

}
