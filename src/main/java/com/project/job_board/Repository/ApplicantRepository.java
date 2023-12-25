package com.project.job_board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.job_board.Entity.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

  Applicant getByFirstName(String firstName);

}
