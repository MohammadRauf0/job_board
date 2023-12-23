package com.project.job_board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.job_board.Entity.Applicant;
import com.project.job_board.Repository.ApplicantRepository;

@Service
public class ApplicantService {

  @Autowired
  ApplicantRepository applicantRepository;

  public List<Applicant> getAllApplicants(){
    return applicantRepository.findAll();
  }
}
