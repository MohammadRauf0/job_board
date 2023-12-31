package com.project.job_board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.job_board.Entity.Applicant;
import com.project.job_board.Repository.ApplicantRepository;

// Service class for Applicant entity
@Service
public class ApplicantService {

  // Autowired annotation to inject ApplicantRepository dependency
  @Autowired
  ApplicantRepository applicantRepository;

  // Method to save a single applicant
  public Applicant saveApplicant(Applicant applicant){
    return applicantRepository.save(applicant);
  }

  // Method to save a list of applicants
  public List<Applicant> saveApplicants(List<Applicant> applicants){
    return applicantRepository.saveAll(applicants);
  }

  // Method to retrieve all applicants
  public List<Applicant> getApplicants(){
    return applicantRepository.findAll();
  }

  // Method to retrieve an applicant by ID
  public Applicant getApplicantById(Long id){
    return applicantRepository.findById(id).orElse(null);
  }

  // Method to retrieve an applicant by first name
  public Applicant getByApplicantName(String firstName){
    return applicantRepository.getByFirstName(firstName);
  }

  // Method to delete an applicant by ID
  public String deleteApplicant(Long id){
    applicantRepository.deleteById(id);
    return "Deleted Successfully " + id;
  }

  // Method to update an existing applicant
  public Applicant updateApplicant(Applicant applicant){
    Applicant existingApplicant = applicantRepository.findById(applicant.getId()).orElse(null);
    if(existingApplicant != null){
      existingApplicant.setFirstName(applicant.getFirstName());
      existingApplicant.setLastName(applicant.getLastName());
      existingApplicant.setEmail(applicant.getEmail());
      existingApplicant.setResume(applicant.getResume());
      existingApplicant.setCoverletter(applicant.getCoverletter());

      return applicantRepository.save(existingApplicant);
    }
    return null;
  }
}