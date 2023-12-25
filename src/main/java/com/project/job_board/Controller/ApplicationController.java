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
import com.project.job_board.Entity.Application;
import com.project.job_board.Entity.Job;
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
  public List<Application> addApplication(@RequestBody List<Application> application) {
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
    Application application = applicationService.getApplicationById(applicationId);
    if (application == null) {
      // Handle the case where the application with the given ID was not found.
      return "Application not found for ID: " + applicationId;
    }
    Job job = application.getJob();
    Applicant applicant = application.getApplicant();
    String result = "Date: " + application.getApplicationDate() + "<br>" +
        "Status: " + application.getStatus() + "<br>" +
        "Notes: " + application.getNotes() + "<br>" +
        "Applicant: <br> {<br> name : " + applicant.getFirstName() +
        " <br> Surname : " + applicant.getLastName() +
        " <br> Email : " + applicant.getEmail() +
        " <br> Resume : " + applicant.getResume() +
        " <br> CoverLetter : " + applicant.getCoverletter() + "<br>}<br>" +
        "Job: <br>{ <br>title:" + job.getTitle() +
        " <br>Location: " + job.getLocation() +
        " <br>Discription: " + job.getDiscription() +
        " <br>Requirements: " + job.getRequirements() +
        " <br>Responsibilities: " + job.getResponsibilities() + "}";
    return result;
  }
}
