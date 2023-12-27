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


@RestController
@RequestMapping("/applicant")
public class ApplicantController {
  @Autowired
  ApplicantService applicantService;

  @PostMapping("/addApplicant")
  public Applicant addApplicant(@RequestBody Applicant applicant){
    return applicantService.saveApplicant(applicant);
  }

  @PostMapping("/addApplicants")
  public List<Applicant> addApplicants(@RequestBody List<Applicant> applicant){
    return applicantService.saveApplicants(applicant);
  }

  @GetMapping("/applicants")
  public List<Applicant> findAllProducts(){
    return applicantService.getApplicants();
  }

  @GetMapping("/applicantById/{id}")
  public Applicant findApplicantById(@PathVariable Long id){
    return applicantService.getApplicantById(id);
  }

  @GetMapping("/applicantByName/{name}")
  public Applicant findApplicantByTitle(@PathVariable String name){
    return applicantService.getByApplicantName(name);
  }

  @PutMapping("/update")
  public Applicant updateApplicant(@RequestBody Applicant applicant){
    return applicantService.updateApplicant(applicant);
  }

  @DeleteMapping("/delete/{id}")
  public String deleteApplicant(@PathVariable Long id){
    return applicantService.deleteApplicant(id);
  }
}
