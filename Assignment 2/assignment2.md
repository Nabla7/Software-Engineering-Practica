# 3-Layer Architecture

| Component | Part of the project |
|---|---|
| Application Layer | Online interface for users |
| Domain Layer | Backend that manages courses, users, content... |
| Database Layer | Databases |


| Advantage | Disadvantage|
|---|---|
| Scalability: layers can be grown/schrunk individually | Performance overhead when switching layers |
| Interchangability of layers | Most traffic goes between layers (database access by domain layer) |
| Maintanance team can specialize in one specific layer | Managing updates can become complex because of the different layers |

| Aspect of the architecture | Non-functional requirements | Functionality |
|---|---|---|
| Layering | Scalability of video streaming | Livestreams |
| Database layer | Secure and realiable database | Saving scores after graduation |
| Domain layer | Easily maintain report types | Add new type of report by developers |

# Blackboard Architecture
| Component | Part of the project |
|---|---|
| Blackboard | Marking assignment, enrolling... |
| Control | Access control (students have different rights than professors) |
| Knowledge sources | Databases & users |

| Advantage | Disadvantage|
|---|---|
| Access control is easy | Unable to support large amount of knowledge sources at the same time |
| Realtime interaction | Difficult to scale when user-count grows rapidly |
| Engagement tracking is easy | Difficult to integrate external data sources which do not neccesarily follow the API of your blackboard |

| Aspect of the architecture | Non-functional requirements | Functionality |
|---|---|---|
| Knowledge sources | Providing accurate enrolment suggestions | Suggestions for program enrollment (easy access to different AI) |


# Single Access Point
| Component | Part of the project |
|---|---|
| Single Access Point | Grading (dont let students modify their grades, only view them) |
| Single Access Point | Dont let students make course announcements |
| Single Acces Point | Course access: only let students view the courses for which they are enrolled|

| Advantage | Disadvantage|
|---|---|
| Simplicity: only having one access point improves simplicity | Scalability: only having one access point doesnt help with scalability |
| Easy control for access | Security vulnerability: if one point fails, its easy to hack in the system |
| Easy installation | Reliability: if the single point fails, entire system can go down |

| Aspect of the architecture | Non-functional requirements | Functionality |
|---|---|---|
| Single acces point | / | Only professors can upload course material, ... |

# Microservice
| Component | Part of the project |
|---|---|
| Multiple Acces Points | Flexible and scalable access for students |
|  |  |

| Advantage | Disadvantage|
|---|---|
| Most access is read access | Lots of data sharing between access points |
| Easily scalable during peak traffic | Updates can take time to reach all systems when traffic is high |
| Easily reroute traffic when one access point is down |  |

| Aspect of the architecture | Non-functional requirements | Functionality |
|---|---|---|
| Multiple access points | Scalability of streaming infrastructure | Divide the load of multiple downloads at the same time by students, professors... |
| Distributes systems | Computing power is divided and easily assignable to lots of departments | Streaming can get it's own system to guaranty 99.99% uptime |

# Spike Stories

### Spike Story 1: Microservice Architecture for Streaming Infrastructure

**Spike:**  
_As a Software Architect, I want to investigate the feasibility and effectiveness of employing a microservice architecture for the streaming infrastructure to effectively scale the system to support fluctuating viewership numbers and guarantee a 99.99% uptime._

**Conditions of Satisfaction:**  

- The microservice should automatically scale to accommodate at least a tenfold increase in simultaneous viewers without degradation in video quality or increased latency.
- The system should recover from a service failure (one microservice going down) in less than 60 seconds to maintain the 99.99% uptime requirement.
- Integration with the main system is seamless, with no noticeable delays for the end-users.
- Video quality of at least 720p is consistently maintained.

---

### Spike Story 2: 3-Layer Architecture for Database Layer's Security and Reliability 

**Spike:**  
_As a Software Architect, I want to evaluate the 3-layer architecture's capabilities for the database layer to ensure scores, assignments, and exams are stored securely and reliably up until 10 years after graduation._

**Conditions of Satisfaction:**  

- The system should provide robust access controls, preventing any unauthorized access or data breaches.
- Data integrity is maintained with no loss or corruption of data over simulated long periods.
- The performance overhead for standard database operations should be within acceptable limits (e.g., less than a 10% increase in response time).
- GDPR requirements, such as the right to access, right to deletion, and data encryption, are successfully implemented and tested.
