package com.project.job_board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.job_board.Entity.Job;
import com.project.job_board.Repository.JobRepository;

@Service
public class JobService {

  @Autowired
  JobRepository jobRepository;

  public Job saveJob(Job job) {
    return jobRepository.save(job);
  }

  public List<Job> saveJobs(List<Job> jobs) {
    return jobRepository.saveAll(jobs);
  }

  public List<Job> getJobs() {
    return jobRepository.findAll();
  }

  public Job getJobById(Long id) {
    return jobRepository.findById(id).orElse(null);
  }

  public Job getJobByTitle(String title) {
    return jobRepository.findByTitle(title);
  }

  public String deleteJob(Long id) {
    jobRepository.deleteById(id);
    return "Deleted Successfully" + id;
  }

  public Job updateJob(Job job) {
    Job existingJob = jobRepository.findById(job.getId()).orElse(null);
    if (existingJob != null) {
      existingJob.setTitle(job.getTitle());
      existingJob.setDiscription(job.getDiscription());
      existingJob.setLocation(job.getLocation());
      existingJob.setRequirements(job.getRequirements());
      existingJob.setResponsibilities(job.getResponsibilities());

      return jobRepository.save(existingJob);
    }
    return null;
  }

}
