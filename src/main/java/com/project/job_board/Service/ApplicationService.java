package com.project.job_board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.job_board.Entity.Application;
import com.project.job_board.Repository.ApplicationRepository;

@Service
public class ApplicationService {

  @Autowired
  ApplicationRepository applicationRepository;

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
}
