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

  public Applicant saveApplicant(Applicant applicant){
    return applicantRepository.save(applicant);
  }

  public List<Applicant> saveApplicants(List<Applicant> applicants){
    return applicantRepository.saveAll(applicants);
  }

  public List<Applicant> getApplicants(){
    return applicantRepository.findAll();
  }

  public Applicant getApplicantById(Long id){
    return applicantRepository.findById(id).orElse(null);
  }

  public Applicant getByApplicantName(String firstName){
    return applicantRepository.getByFirstName(firstName);
  }

  public String deleteApplicant(Long id){
    applicantRepository.deleteById(id);
    return "Deleted Sucessfully" + id;
  }

  public Applicant updateApplicant(Applicant applicant){
    Applicant existingApplicant = applicantRepository.findById(applicant.getId()).orElse(null);
    existingApplicant.setFirstName(applicant.getFirstName());
    existingApplicant.setLastName(applicant.getLastName());
    existingApplicant.setEmail(applicant.getEmail());
    existingApplicant.setResume(applicant.getResume());
    existingApplicant.setCoverletter(applicant.getCoverletter());
    existingApplicant.setApplications(applicant.getApplications());
    return applicantRepository.save(existingApplicant);
  }
}
