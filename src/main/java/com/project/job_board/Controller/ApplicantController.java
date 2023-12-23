package com.project.job_board.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.job_board.Entity.Applicant;
import com.project.job_board.Service.ApplicantService;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {
  @Autowired
  ApplicantService applicantService;

  @GetMapping
  public List<Applicant> getAllApplicants(){
    return applicantService.getAllApplicants();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Applicant> getApplicantById(@PathVariable Long id){
    Applicant applicant = applicantService.getApplicantById(id);
    return ResponseEntity.ok().body(applicant);
  }

  @PostMapping
  public ResponseEntity<Applicant> createApplicant(@RequestBody Applicant applicant){
    Applicant createdApplicant = applicantService.createApplicant(applicant);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdApplicant);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Applicant> updateApplicant(@PathVariable Long id, @RequestBody Applicant applicant){
    Applicant updatedApplicant = applicantService.updateApplicant(id, applicant);
    return ResponseEntity.ok().body(updatedApplicant);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Applicant> deleteApplicant(@PathVariable Long id){
    applicantService.deleteApplicant(id);
    return ResponseEntity.noContent().build();
  }

}
