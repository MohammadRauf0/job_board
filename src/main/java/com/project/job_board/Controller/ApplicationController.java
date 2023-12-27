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

import com.project.job_board.Entity.Application;
import com.project.job_board.Service.ApplicationService;

@RestController
@RequestMapping("/application")
public class ApplicationController {
  @Autowired
  ApplicationService applicationService;

  @PostMapping("/addApplication")
  public Application addApplication(@RequestBody Application application) {
    return applicationService.saveApplication(application);
  }

  @PostMapping("/addApplications")
  public List<Application> addApplications(@RequestBody List<Application> application) {
    return applicationService.saveApplications(application);
  }

  @GetMapping("/applications")
  public List<Application> findAllProducts() {
    return applicationService.getApplications();
  }

  @GetMapping("/applicationById/{id}")
  public Application findApplicationById(@PathVariable Long id) {
    return applicationService.getApplicationById(id);
  }

  @PutMapping("/update")
  public Application updateApplication(@RequestBody Application application) {
    return applicationService.updateApplication(application);
  }

  @DeleteMapping("/delete/{id}")
  public String deleteApplication(@PathVariable Long id) {
    return applicationService.deleteApplication(id);
  }

  @GetMapping("/ApplicantAndJob/{applicationId}")
  public String applicationJob(@PathVariable Long applicationId) {
    return applicationService.applicationJob(applicationId);
  }

  // @PostMapping("/setEmployer/{applicationId}/{employerId}")
  // public Application setEmployer(@PathVariable Long applicationId, @PathVariable Long employerId){
  //   return applicationService.setEmployer(applicationId, employerId);
  // }

  @PostMapping("/setJob/{applicationId}/{jobId}")
  public Application setJob(@PathVariable Long applicationId, @PathVariable Long jobId){
    return applicationService.setJob(applicationId, jobId);
  }

  @PostMapping("/setApplicant/{applicationId}/{applicantId}")
  public Application setApplicant(@PathVariable Long applicationId, @PathVariable Long applicantId){
    return applicationService.setApplicant(applicationId, applicantId);
  }

  @PostMapping("/setAllRelations/{ApplicationId}/{applicantId}/{jobId}/{EmployerId}")
  public Application setAllRelations(@PathVariable Long applicationId,@PathVariable Long applicantId, @PathVariable Long jobId, @PathVariable Long employerId){
    return applicationService.setEverything(applicationId, applicantId, jobId, employerId);
  }

  @PostMapping("/create/{applicantId}/{jobId}/{employerId}")
  public Application create(@RequestBody Application application, @PathVariable Long applicantId,@PathVariable Long jobId, @PathVariable Long employerId){
    return applicationService.createApplication(application, applicantId, jobId, employerId);
  }

  @GetMapping("/jobApplications/{jobId}")
  public List<Application> getApplicationByJobId(@PathVariable Long jobId){
    return applicationService.getApplicationsByJobId(jobId);
  }

  @GetMapping("/employerApplications/{employerId}")
  public List<Application> getApplicationByEmployerId(@PathVariable Long employerId){
    return applicationService.getApplicationsByEmployerId(employerId);
  }

  @GetMapping("/applicantApplications/{applicantId}")
  public List<Application> getApplicationsByUserId(@PathVariable Long applicantId){
    return applicationService.getApplicationsByApplicantId(applicantId);
  }

  @PostMapping("/createApplication/{applicantId}/{jobId}")
  public Application createApplication(@RequestBody Application application, @PathVariable Long applicantId, @PathVariable Long jobId){
    return applicationService.makeApplication(application, applicantId, jobId);
  }
 
}
