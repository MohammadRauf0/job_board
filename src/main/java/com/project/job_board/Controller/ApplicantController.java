package com.project.job_board.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

// RestController class for handling HTTP requests related to Applicant entity
@RestController
@RequestMapping("/applicant")
public class ApplicantController {

  // Autowired annotation to inject ApplicantService dependency
  @Autowired
  ApplicantService applicantService;

  // Endpoint to add a single applicant
  @PostMapping("/addApplicant")
  public Applicant addApplicant(@RequestBody Applicant applicant){
    return applicantService.saveApplicant(applicant);
  }

  // Endpoint to add a list of applicants
  @PostMapping("/addApplicants")
  public List<Applicant> addApplicants(@RequestBody List<Applicant> applicant){
    return applicantService.saveApplicants(applicant);
  }

  // Endpoint to retrieve all applicants
  @GetMapping("/applicants")
  public List<Applicant> findAllProducts(){
    return applicantService.getApplicants();
  }

  // Endpoint to retrieve an applicant by ID
  @GetMapping("/applicantById/{id}")
  public Applicant findApplicantById(@PathVariable Long id){
    return applicantService.getApplicantById(id);
  }

  // Endpoint to retrieve an applicant by name
  @GetMapping("/applicantByName/{name}")
  public Applicant findApplicantByTitle(@PathVariable String name){
    return applicantService.getByApplicantName(name);
  }

  // Endpoint to update an existing applicant
  @PutMapping("/update")
  public Applicant updateApplicant(@RequestBody Applicant applicant){
    return applicantService.updateApplicant(applicant);
  }

  // Endpoint to delete an applicant by ID
  @DeleteMapping("/delete/{id}")
  public String deleteApplicant(@PathVariable Long id){
    return applicantService.deleteApplicant(id);
  }
}
