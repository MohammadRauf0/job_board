package com.project.job_board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.job_board.Entity.Application;
import com.project.job_board.Entity.Employer;
import com.project.job_board.Entity.Job;
import com.project.job_board.Repository.EmployerRepository;
import com.project.job_board.Repository.JobRepository;

// Service class for Employer entity
@Service
public class EmployerService {

  // Autowired annotations to inject repository dependencies
  @Autowired
  EmployerRepository employerRepository;

  @Autowired
  JobRepository jobRepository;

  // Method to save a single employer
  public Employer saveEmployer(Employer employer) {
    return employerRepository.save(employer);
  }

  // Method to save a list of employers
  public List<Employer> saveEmployers(List<Employer> employers) {
    return employerRepository.saveAll(employers);
  }

  // Method to retrieve all employers
  public List<Employer> getEmployers() {
    return employerRepository.findAll();
  }

  // Method to retrieve an employer by ID
  public Employer getEmployerById(Long id) {
    return employerRepository.findById(id).orElse(null);
  }

  // Method to retrieve an employer by company name
  public Employer getByEmployerName(String companyName) {
    return employerRepository.findByCompanyName(companyName);
  }

  // Method to delete an employer by ID
  public String deleteEmployer(Long id) {
    employerRepository.deleteById(id);
    return "Deleted Successfully " + id;
  }

  // Method to update an existing employer
  public Employer updateEmployer(Employer employer) {
    Employer existingEmployer = employerRepository.findById(employer.getId()).orElse(null);
    if (existingEmployer != null) {
      existingEmployer.setCompanyName(employer.getCompanyName());
      existingEmployer.setDescription(employer.getDescription());
      existingEmployer.setIndustry(employer.getIndustry());
      existingEmployer.setInformation(employer.getInformation());

      return employerRepository.save(existingEmployer);
    }
    return null;
  }

  // Method to retrieve applications associated with an employer
  public List<Application> employerApplication(Long id) {
    Employer employer = this.getEmployerById(id);
    return employer.getApplications();
  }

  // Method to create and save a new job associated with an employer
  public Job newJob(Long employerId, Job job) {
    Employer employer = this.getEmployerById(employerId);
    if (employer != null) {
      job.setEmployer(employer);
      jobRepository.save(job);
      employer.addJob(job);
      employerRepository.flush();
      return job;
    }
    return null;
  }

  // Method to create and save a list of new jobs associated with an employer
  public List<Job> newJobs(Long employerId, List<Job> jobs) {
    Employer employer = this.getEmployerById(employerId);
    if (employer != null) {
      for (Job job : jobs) {
        job.setEmployer(employer);
        jobRepository.save(job);
        employer.addJob(job);
      }
      employerRepository.flush();
      System.out.println("COMPLETED");
      return jobRepository.findByEmployerId(employerId);
    }
    return null;
  }
}