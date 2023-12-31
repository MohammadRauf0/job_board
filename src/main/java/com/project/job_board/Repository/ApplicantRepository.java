package com.project.job_board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.job_board.Entity.Applicant;

// Interface extending JpaRepository for Applicant entity, with Long as the type of the primary key
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

  // Method signature for a custom query to retrieve an Applicant by their first name
  Applicant getByFirstName(String firstName);

}
