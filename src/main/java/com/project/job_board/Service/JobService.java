package com.project.job_board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.job_board.Entity.Employer;
import com.project.job_board.Entity.Job;
import com.project.job_board.Repository.EmployerRepository;
import com.project.job_board.Repository.JobRepository;

// Service class for Job entity
@Service
public class JobService {

  // Autowired annotations to inject repository dependencies
  @Autowired
  JobRepository jobRepository;

  @Autowired
  EmployerRepository employerRepository;

  // Method to save a single job
  public Job saveJob(Job job) {
    return jobRepository.save(job);
  }

  // Method to save a list of jobs
  public List<Job> saveJobs(List<Job> jobs) {
    return jobRepository.saveAll(jobs);
  }

  // Method to retrieve all jobs
  public List<Job> getJobs() {
    return jobRepository.findAll();
  }

  // Method to retrieve a job by ID
  public Job getJobById(Long id) {
    return jobRepository.findById(id).orElse(null);
  }

  // Method to retrieve a job by title
  public Job getJobByTitle(String title) {
    return jobRepository.findByTitle(title);
  }

  // Method to delete a job by ID
  public String deleteJob(Long id) {
    jobRepository.deleteById(id);
    return "Deleted Successfully " + id;
  }

  // Method to update an existing job
  public Job updateJob(Job job) {
    Job existingJob = jobRepository.findById(job.getId()).orElse(null);
    if (existingJob != null) {
      existingJob.setTitle(job.getTitle());
      existingJob.setDescription(job.getDescription());
      existingJob.setLocation(job.getLocation());
      existingJob.setRequirements(job.getRequirements());
      existingJob.setResponsibilities(job.getResponsibilities());

      return jobRepository.save(existingJob);
    }
    return null;
  }

  // Method to create and save a job associated with an employer
  public Job JobFromEmployer(Long employerId, Job job) {
    Employer employer = employerRepository.findById(employerId).orElse(null);
    if (employer == null) {
      return null;
    }
    job.setEmployer(employer);
    jobRepository.save(job);
    employer.addJob(job);
    employerRepository.flush();
    return job;
  }

  // Method to retrieve jobs by employer ID
  public List<Job> findByEmployerId(Long employerId) {
    return jobRepository.findByEmployerId(employerId);
  }
}