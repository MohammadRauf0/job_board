package com.project.job_board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.job_board.Entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long>{

}
