package com.project.job_board.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.job_board.Entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long>{

  List<Application> findByJobId(Long jobId);

  List<Application> findByEmployerId(Long employerId);

  List<Application> findByApplicantId(Long applicantId);

}
