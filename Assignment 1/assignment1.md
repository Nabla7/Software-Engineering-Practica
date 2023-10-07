# Part 1

### 1: Identify all actors.

Based on the document, the identified actors are:
1. Students
2. Administrative Aids
3. Professors
4. Assistants
5. University (for program review and adjustments)
6. IT-Department (developers)
7. Database

### 2: Identify 20 use cases.
1. Students enroll in a program.
2. Students enroll in courses.
3. Administrative Aids process enrollment applications.
4. Students receive notifications of enrollment status.
5. Students pay tuition.
6. Students receive suggestions for programs and courses.
7. Professors upload lecture recordings.
8. Professors livestream lectures.
9. Professors upload course materials and announcements.
10. Professors and Assistants interact with students during lectures.
11. Students, Professors, and Assistants synchronize schedules with digital calendars.
12. Assistants create assignments.
13. Students view and submit assignments.
14. Plagiarism detection on student assignments.
15. Students view their scores and feedback.
16. Assistants and Professors grade assignments and exams.
17. University adjusts and reviews programs.
18. IT-Department creates statistical reports.
19. IT-Department adds new types of reports.
20. Data securely stored and managed.

### 3: Responsibilities for each actor.
1. **Students**: 
   - Enroll in programs and courses.
   - Pay tuition.
   - Attend lectures and complete assignments.
   - View their scores and feedback.
   
2. **Administrative Aids**:
   - Process enrollment applications.
   - Approve or decline late enrollments.
   
3. **Professors**:
   - Deliver lectures (upload recordings or livestream).
   - Provide course materials and announcements.
   - Grade exams.
   
4. **Assistants**:
   - Create and grade assignments.
   - Provide supplementary material for assignments.
   - Interact with students during lectures.
   
5. **University**:
   - Review and adjust academic programs.
   - Require statistical reports for decision making.
   
6. **IT-Department**:
   - Develop and maintain the platform.
   - Create and manage statistical reports.
     
7. **Database**
   - Securely store data

### 4: Goals for each actor linked to use cases.
1. **Students**:
   - Enroll in programs and courses (Use Cases: 1, 2).
   - Pay tuition (Use Case: 5).
   - Attend lectures and complete assignments (Use Cases: 7, 8, 13).
   - View their scores and feedback (Use Case: 15).
   
2. **Administrative Aids**:
   - Process enrollment applications (Use Cases: 3, 4).
   - Approve or decline late enrollments (Implied from text).
   
3. **Professors**:
   - Deliver lectures (Use Cases: 7, 8).
   - Provide course materials and announcements (Use Case: 9).
   - Grade exams (Use Case: 16).
   
4. **Assistants**:
   - Create and grade assignments (Use Cases: 12, 16).
   - Provide supplementary material for assignments (Implied from text).
   - Interact with students during lectures (Use Case: 10).
   
5. **University**:
   - Review and adjust academic programs (Use Case: 17).
   - Require statistical reports for decision making (Use Case: 18).
   
6. **IT-Department**:
   - Create and manage statistical reports (Use Cases: 18, 19).

7. **Database**
   - Securely store data

### 5: Use case diagram
![Diagram](IMG_0325.jpg)


# Part 2
### 1: Scenarios
| Student enrolls in a program |  |
| --- | --- |
| **Audience** | System development team |
| **Level** | Specific functionality |
| **Granularity** | Detailed |
| **Preconditions** | Student has an account on the platform. There is an administrative aid linked to each program to process enrollments. |
| **Success condition** | Student is enrolled in the program they chose and enrollment is send to the correct administrative aid. If the deadline has passed, there should have been approval from an administrative aid |
| **Fail condition** | Student can enroll in a program after the deadline without approval from a administrative aid. Student cannot enroll in a program before the deadline. An enrollment is not send or send to the wrong administrative aid. Administrative aid cannot give approval for late enrollments. |
| **Primary actors** | Student |
| **Secondary actors** | Administrative aids |
| **Trigger** | Student enrolls |


| **Plagiarism detection on student assignments** ||
| --- | --- |
| **Audience** | System development team |
| **Level** | Specific Functionality |
| **Granularity** | Detailed |
| **Preconditions** | Assignments have been submitted and the deadline is closed |
| **Succes condition** | The plagiarism detection program runs after the deadline and checks the chance the student committed plagiarism|
| **Fail condition** | The plagiarism detection software fails to find if a student has committed plagiarism |
| **Primary actors** | Professor, assistant |
| **Secondary actors** | |
| **Trigger** |The deadline of an assignment has passed |


### 2: Step by step description of execution of Plagiarism detection on student assignments
| Step | Action |
| --- | --- |
| 1 | Deadline of an assignment has passed |
| 2 | The system retrieves the submitted assignments from the server |
| 3 | For each assignment that is returned from the server : |
| 3.1 | The system calculates the similarity scores and adds it to the plagiarism report |
| 3.2 | If the systems find a similarity above a certain threshold it flags the assignment |
| 4 | The system generates a plagiarism report and attaches it to the assignments |
| 5 | The system notifies the professor / teaching assistant of the flagged assignments |
| **Branch** | Exceptions |
| Any | If the system fails or crashes it should notify the software devolpment team with an error log |
| After 2 | If there are no submissions, the system should stop running |



# Part 3 :  User story cards

### **INVEST Criteria**

The INVEST criteria help in ensuring that each user story in a product backlog is well-constructed:

- **I: Independent**: Each story can be developed, tested, and deployed independently.
- **N: Negotiable**: The story provides high-level requirements, allowing room for discussions between stakeholders and the development team.
- **V: Value**: Each story offers clear value to its actor.
- **E: Estimable**: Given the clear requirements, the development team can estimate the effort for the story.
- **S: Small**: Each story is focused on a specific functionality.
- **T: Testable**: Acceptance criteria are provided for each story, allowing for test case creation.

---

### **User Story 1: Plagiarism Detection**

**Title**: Plagiarism Detection on Student Assignments

**Story**: 
*As a professor, I want all the assignments to be checked by plagiarism detection software and a report of it attached to the assignment so that academic integrity is ensured.*

**Acceptance Criteria**:
1. The system should automatically run the plagiarism check after the assignment deadline.
2. The system should generate a plagiarism report for each assignment.
3. Assignments with similarity scores above a certain threshold should be flagged.
4. Professors/assistants should be notified of the flagged assignments.

**INVEST Analysis**:
- **I**: This story focuses solely on plagiarism detection, making it independent from other functionalities.
- **N**: It provides a high-level goal without specifying the methods, leaving room for negotiation.
- **V**: Ensuring academic integrity provides clear value.
- **E**: The tasks required are clear enough to provide estimations.
- **S**: The story is dedicated to one functionality: plagiarism detection.
- **T**: Given the acceptance criteria, tests can be designed to validate the story.

---

### **User Story 2: Administrators Processing Enrollments**

**Title**: Processing Student Enrollments

**Story**: 
*As an administrative aid, I want to be able to process student enrollments so that students can be formally admitted into their desired programs and courses.*

**Acceptance Criteria**:
1. The system should allow administrative aids to view pending enrollments.
2. Administrative aids should have the capability to approve or decline enrollments.
3. The system should notify students of their enrollment status once processed.
4. Administrative aids should be able to process late enrollments with special approval.

**INVEST Analysis**:
- **I**: This story is focused on enrollment processing, independent of other functionalities.
- **N**: The story gives an overarching goal, leaving implementation details open to negotiation.
- **V**: Efficiently processing enrollments provides value to both administrative aids and students.
- **E**: The tasks mentioned allow for an estimation of effort.
- **S**: The story exclusively addresses enrollment processing.
- **T**: With clear acceptance criteria, tests can be developed to ensure functionality.

---

### **User Story 3: Student Tuition Payment**

**Title**: Paying Tuition Fees

**Story**: 
*As a student, I want to be able to pay my tuition fees through the platform so that I can secure my enrollment and access the courses I've registered for.*

**Acceptance Criteria**:
1. The system should display the due tuition amount for the student.
2. The system should provide secure payment options (credit card, bank transfer, etc.).
3. Upon successful payment, the system should provide a digital receipt to the student.
4. In case of payment failure, the system should notify the student and suggest retrying.

**INVEST Analysis**:
- **I**: This story specifically deals with tuition payment, independent from other stories.
- **N**: It outlines the need without delving into precise methods, allowing for negotiation.
- **V**: Ensuring a smooth tuition payment process is valuable for both students and the institution.
- **E**: The requirements are clear enough for the team to estimate effort.
- **S**: The story is centered on the tuition payment process.
- **T**: The acceptance criteria enable the creation of comprehensive tests. 

 
 ## Questions for the customer:
* From what grade of similarity with outside sources should assignments be flagged as "potentially plagiarized"
* Do we use this system to ask approval of the administrative aid when a student is late for enrollment, or is this a completely different system?
