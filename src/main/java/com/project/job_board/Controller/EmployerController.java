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
import com.project.job_board.Entity.Employer;
import com.project.job_board.Entity.Job;
import com.project.job_board.Service.EmployerService;

@RestController
@RequestMapping("/employer")
public class EmployerController {
  @Autowired
  EmployerService employerService;

  @PostMapping("/addEmployer")
  public Employer addEmployer(@RequestBody Employer employer){
    return employerService.saveEmployer(employer);
  }

  @PostMapping("/addEmployers")
  public List<Employer> addEmployers(@RequestBody List<Employer> employer){
    return employerService.saveEmployers(employer);
  }

  @GetMapping("/employers")
  public List<Employer> findAllProducts(){
    return employerService.getEmployers();
  }

  @GetMapping("/employerById/{id}")
  public Employer findEmployerById(@PathVariable Long id){
    return employerService.getEmployerById(id);
  }

  @GetMapping("/employerByTitle/{title}")
  public Employer findEmployerByTitle(@PathVariable String title){
    return employerService.getByEmployerName(title);
  }

  @PutMapping("/update")
  public Employer updateEmployer(@RequestBody Employer employer){
    return employerService.updateEmployer(employer);
  }

  @DeleteMapping("/delete/{id}")
  public String deleteEmployer(@PathVariable Long id){
    return employerService.deleteEmployer(id);
  }

  @GetMapping("/applications/{id}")
  public List<Application> getApplications(@PathVariable Long id){
    return employerService.employerApplication(id);
  }

  @PostMapping("/newJob/{employerId}")
  public Job newJob(@PathVariable Long employerId, @RequestBody Job job){
    return employerService.newJob(employerId, job);
  }

  @PostMapping("/newJobs/{employerId}")
  public List<Job> newJobs(@PathVariable Long employerId, @RequestBody List<Job> job){
    return employerService.newJobs(employerId, job);
  }
}
