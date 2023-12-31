package com.project.job_board.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.job_board.Entity.Application;

// Interface extending JpaRepository for Application entity, with Long as the type of the primary key
public interface ApplicationRepository extends JpaRepository<Application, Long>{

  // Custom query method to find applications by job ID
  List<Application> findByJobId(Long jobId);

  // Custom query method to find applications by employer ID
  List<Application> findByEmployerId(Long employerId);

  // Custom query method to find applications by applicant ID
  List<Application> findByApplicantId(Long applicantId);

}
