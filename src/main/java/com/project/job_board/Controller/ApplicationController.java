package com.project.job_board.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.job_board.Service.ApplicationService;

@RestController
@RequestMapping("/application")
public class ApplicationController {
  @Autowired
  ApplicationService applicationService;

  
}
