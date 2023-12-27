package com.project.job_board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.job_board.Entity.Application;
import com.project.job_board.Entity.Employer;
import com.project.job_board.Entity.Job;
import com.project.job_board.Repository.EmployerRepository;
import com.project.job_board.Repository.JobRepository;

@Service
public class EmployerService {

  @Autowired
  EmployerRepository employerRepository;

  @Autowired
  JobRepository jobRepository;

  public Employer saveEmployer(Employer employer) {
    return employerRepository.save(employer);
  }

  public List<Employer> saveEmployers(List<Employer> employers) {
    return employerRepository.saveAll(employers);
  }

  public List<Employer> getEmployers() {
    return employerRepository.findAll();
  }

  public Employer getEmployerById(Long id) {
    return employerRepository.findById(id).orElse(null);
  }

  public Employer getByEmployerName(String companyName) {
    return employerRepository.findByCompanyName(companyName);
  }

  public String deleteEmployer(Long id) {
    employerRepository.deleteById(id);
    return "Deleted Sucessfully" + id;
  }

  public Employer updateEmployer(Employer employer) {
    Employer existingEmployer = employerRepository.findById(employer.getId()).orElse(null);
    if (existingEmployer != null) {
      existingEmployer.setCompanyName(employer.getCompanyName());
      existingEmployer.setDiscription(employer.getDiscription());
      existingEmployer.setIndustry(employer.getIndustry());
      existingEmployer.setInformation(employer.getInformation());

      return employerRepository.save(existingEmployer);
    }
    return null;
  }

  public List<Application> employerApplication(Long id) {
    Employer employer = this.getEmployerById(id);
    return employer.getApplications();
  }

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
