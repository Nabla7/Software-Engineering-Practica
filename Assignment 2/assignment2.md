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