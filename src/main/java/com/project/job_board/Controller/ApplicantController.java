package com.project.job_board.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.job_board.Entity.Applicant;
import com.project.job_board.Service.ApplicantService;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {
  @Autowired
  ApplicantService ApplicantService;

  @GetMapping
  public List<Applicant> getAllApplicants(){
    return ApplicantService.getAllApplicants();
  }

}
