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

import com.project.job_board.Entity.Job;
import com.project.job_board.Service.JobService;

@RestController
@RequestMapping("/job")
public class JobController {
  @Autowired
  JobService jobService;

  @PostMapping("/addJob")
  public Job addJob(@RequestBody Job job){
    return jobService.saveJob(job);
  }

  @PostMapping("/addJobs")
  public List<Job> addJobs(@RequestBody List<Job> job){
    return jobService.saveJobs(job);
  }

  @GetMapping("/jobs")
  public List<Job> findAllProducts(){
    return jobService.getJobs();
  }

  @GetMapping("/jobById/{id}")
  public Job findJobById(@PathVariable Long id){
    return jobService.getJobById(id);
  }

  @GetMapping("/jobByTitle/{title}")
  public Job findJobByTitle(@PathVariable String title){
    return jobService.getJobByTitle(title);
  }

  @PutMapping("/update")
  public Job updateJob(@RequestBody Job job){
    return jobService.updateJob(job);
  }

  @DeleteMapping("/delete/{id}")
  public String deleteJob(@PathVariable Long id){
    return jobService.deleteJob(id);
  }

  @PostMapping("/newFromEmployer")
  public Job jobFromEmployer(@PathVariable Long employerId, @RequestBody Job job){
    return jobService.JobFromEmployer(employerId, job);
  }
}
