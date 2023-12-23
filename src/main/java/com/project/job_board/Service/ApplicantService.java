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

  public Applicant getApplicantById(Long id){
    return applicantRepository.findById(id).orElse(null);
  }

  public Applicant createApplicant(Applicant applicant){
    return applicantRepository.save(applicant);
  }

  public Applicant updateApplicant(Long id, Applicant updatedApplicant){
    Applicant existingApplicant = applicantRepository.findById(id).orElse(null);
    if(existingApplicant!=null){
      return applicantRepository.save(updatedApplicant);
    }
    return null;
  }

  public void deleteApplicant(Long id){
    applicantRepository.deleteById(id);
  }
}
