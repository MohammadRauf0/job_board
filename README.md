  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

# Job Board Spring Boot Application

Welcome to the Job Board Spring Boot application! This project has undergone multiple modifications and edits, so it is highly recommended to clone it using GitHub.

## GitHub Repository

🔗 **[Job Board Repository](https://github.com/MohammadRauf0/job_board.git)**

## Setup Instructions

1. Execute the provided script file from MySQL Workbench under the "Server" menu in the "Data Import" section.
2. The project folder also contains the schema you need.
3. There is a hidden folder containing the documentation in PDF format; make sure to explore it.

## Configuration

- Check and adjust your application properties and parameters to match your environment before running the application.

## Eclipse IDE Users

- If you encounter issues with the `pom.xml` file in Eclipse, use the provided `pom.xml` in the documentation.

## Prerequisites

- Ensure that WAMPserver is running for the application to start successfully.

## Documentation Structure

1. **Introduction:** Initial overview with tables filled with data used for testing.
2. **Eclipse Users:** Instructions and `pom.xml` file for Eclipse users.
3. **Entities, Repositories, Services, and Controllers:** Detailed information about these components.
4. **CRUD Operations:** Testing of CRUD operations on one entity; other entities were replicated.
5. **Endpoints and API Testing:** Overview of endpoints and API tester tests.
6. **Custom Functions:** Testing of custom functions and main application endpoints.
7. **GitHub Commits:** Detailed history of GitHub commits.

## Endpoints

### ApplicantController:

- `POST /applicant/addApplicant`
- `POST /applicant/addApplicants`
- `GET /applicant/applicants`
- `GET /applicant/applicantById/{id}`
- `GET /applicant/applicantByName/{name}`
- `PUT /applicant/update`
- `DELETE /applicant/delete/{id}`

### ApplicationController:

- `POST /application/addApplication`
- `POST /application/addApplications`
- `GET /application/applications`
- `GET /application/applicationById/{id}`
- `PUT /application/update`
- `DELETE /application/delete/{id}`
- `GET /application/ApplicantAndJob/{applicationId}`
- `POST /application/setJob/{applicationId}/{jobId}`
- `POST /application/setApplicant/{applicationId}/{applicantId}`
- `POST /application/setAllRelations/{ApplicationId}/{applicantId}/{jobId}/{EmployerId}`
- `POST /application/create/{applicantId}/{jobId}/{employerId}`
- `GET /application/jobApplications/{jobId}`
- `GET /application/employerApplications/{employerId}`
- `GET /application/applicantApplications/{applicantId}`
- `POST /application/createApplication/{applicantId}/{jobId}`

### EmployerController:

- `POST /employer/addEmployer`
- `POST /employer/addEmployers`
- `GET /employer/employers`
- `GET /employer/employerById/{id}`
- `GET /employer/employerByTitle/{title}`
- `PUT /employer/update`
- `DELETE /employer/delete/{id}`
- `GET /employer/applications/{id}`
- `POST /employer/newJob/{employerId}`
- `POST /employer/newJobs/{employerId}`

### JobController:

- `POST /job/addJob`
- `POST /job/addJobs`
- `GET /job/jobs`
- `GET /job/jobById/{id}`
- `GET /job/jobByTitle/{title}`
- `PUT /job/update`
- `DELETE /job/delete/{id}`
- `POST /job/newFromEmployer`
