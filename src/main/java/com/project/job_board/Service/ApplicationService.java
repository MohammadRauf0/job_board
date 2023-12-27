package com.project.job_board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.job_board.Entity.Applicant;
import com.project.job_board.Entity.Application;
import com.project.job_board.Entity.Employer;
import com.project.job_board.Entity.Job;
import com.project.job_board.Repository.ApplicantRepository;
import com.project.job_board.Repository.ApplicationRepository;
import com.project.job_board.Repository.EmployerRepository;
import com.project.job_board.Repository.JobRepository;

@Service
public class ApplicationService {

  @Autowired
  ApplicationRepository applicationRepository;

  @Autowired
  EmployerRepository employerRepository;

  @Autowired
  JobRepository jobRepository;

  @Autowired
  ApplicantRepository applicantRepository;

  public Application saveApplication(Application application){
    return applicationRepository.save(application);
  }

  public List<Application> saveApplications(List<Application> applications){
    return applicationRepository.saveAll(applications);
  }

  public List<Application> getApplications(){
    return applicationRepository.findAll();
  }

  public Application getApplicationById(Long id){
    return applicationRepository.findById(id).orElse(null);
  }

  public String deleteApplication(Long id){
    applicationRepository.deleteById(id);
    return "Deleted Sucessfully" + id;
  }

  public Application updateApplication(Application application){
    Application existingApplication = applicationRepository.findById(application.getId()).orElse(null);
    existingApplication.setStatus(application.getStatus());
    existingApplication.setApplicationDate(application.getApplicationDate());
    existingApplication.setNotes(application.getNotes());
    existingApplication.setJob(application.getJob());
    existingApplication.setApplicant(application.getApplicant());
    existingApplication.setEmployer(application.getEmployer());
    return applicationRepository.save(existingApplication);
  }

  public String applicationJob(Long applicationId) {
    Application application = getApplicationById(applicationId);
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
        " <br>Responsibilities: " + job.getResponsibilities() + "<br>}";
    return result;
  }

  public Application setEmployer(Long applicationId, Long employerId){
    Employer employer = employerRepository.findById(employerId).orElse(null);
    Application application = applicationRepository.findById(applicationId).orElse(null);
    application.setEmployer(employer);
    applicationRepository.save(application);
    employer.addApplication(application);
    employerRepository.flush();
    return application;
  }

  public Application setJob(Long applicationId, Long jobId) {
    Job job = jobRepository.findById(jobId).orElse(null);
    Application application = applicationRepository.findById(applicationId).orElse(null);
    application.setJob(job);
    applicationRepository.save(application);
    job.addApplication(application);
    jobRepository.flush();
    return application;
  }

  public Application setApplicant(Long applicationId, Long applicantId){
    Applicant applicant = applicantRepository.findById(applicantId).orElse(null);
    Application application = applicationRepository.findById(applicationId).orElse(null);
    application.setApplicant(applicant);
    applicationRepository.save(application);
    applicant.addApplication(application);
    jobRepository.flush();
    return application;
  }

  public Application setEverything(Long applicationId, Long applicantId, Long JobId, Long EmployerId){
    setApplicant(applicationId, applicantId);
    setEmployer(applicationId, EmployerId);
    setJob(applicationId, JobId);
    return getApplicationById(applicationId);
  }

  public Application createApplication(Application application, Long applicantId, Long jobId, Long employerId){
    saveApplication(application);
    setApplicant(application.getId(), applicantId);
    setEmployer(application.getId(), employerId);
    setJob(application.getId(), jobId);
    return application;
  }

  public List<Application> getApplicationsByJobId(Long jobId){
    return applicationRepository.findByJobId(jobId);
  }

  public List<Application> getApplicationsByEmployerId(Long employerId){
    return applicationRepository.findByEmployerId(employerId);
  }

  public List<Application> getApplicationsByApplicantId(Long applicantId){
    return applicationRepository.findByApplicantId(applicantId);
  }

  public Application makeApplication(Application application, Long applicantId, Long jobId){
    Job job = jobRepository.findById(jobId).orElse(null);
    if(job==null){
      return null;
    }
    Employer employer = job.getEmployer();
    Applicant applicant = applicantRepository.findById(applicantId).orElse(null);
    if(applicant==null){
      return null;
    }
    application.setEmployer(employer);
    application.setJob(job);
    application.setApplicant(applicant);

    applicationRepository.save(application);

    employer.addApplication(application);
    job.addApplication(application);
    applicant.addApplication(application);

    employerRepository.flush();
    applicantRepository.flush();
    jobRepository.flush();
    return application;
  }
}