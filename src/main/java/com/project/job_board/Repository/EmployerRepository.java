package com.project.job_board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.job_board.Entity.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long>{

}
