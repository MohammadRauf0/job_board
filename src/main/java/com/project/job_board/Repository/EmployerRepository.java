package com.project.job_board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.job_board.Entity.Employer;

// Interface extending JpaRepository for Employer entity, with Long as the type of the primary key
public interface EmployerRepository extends JpaRepository<Employer, Long>{

  // Custom query method to find an employer by company name
  Employer findByCompanyName(String companyName);

}