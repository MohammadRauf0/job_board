package com.project.job_board.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Data, AllArgsConstructors and NoArgsConstructor takes care of constructors, getters and setters
@Data
@AllArgsConstructor
@NoArgsConstructor

// the anotation bellow is responsible for letting springboot know that this is
// an entity
@Entity

// the annotation bellow handles the name of the data table in the database
// IS OPTIONAL
@Table(name = "employerTable")
public class Employer {
  // Id annotation bellow is used to specify the primary key attribute of an
  // entity
  // GeneratedValue Specifies that the 'id' field is a primary key with values
  // generated by the
  // database using an identity column.
  // Column annotation bellow maps the 'id' field to a database column named 'id'.
  // IS OPTIONAL
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  Long id;

  String companyName, discription, information, industry;

  @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  List<Application> applications;

}
