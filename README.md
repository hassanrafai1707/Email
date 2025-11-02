# 📧 IAC 'Community Ambassador' Onboarding Process  
### Global Professional Internship (GPI) Project  
**Duration:** 120 Hours | **Organization:** Cloud Counselage IAC  
**Domain:** Java Backend Development | **Intern:** Hassan Abdul Rahim Patel  

---

## 🧩 Problem Statement

The *Industry Academia Community (IAC)* aims to help 10 million students become *job-ready by 2028*.  
Community Ambassadors (CAs) are the bridge between IAC and students, spreading awareness and assisting peers in onboarding to IAC programs.

To assess their efforts, each CA is assigned a unique **UTM link**. Tracking and automating this process ensures efficient performance monitoring and onboarding.

---

## 🏁 Objective

Develop a **Java-based web application** to automate the *Community Ambassador Onboarding Process*, including:
- Automating UTM link generation and distribution.
- Sending welcome emails automatically upon form submission.
- Tracking CA performance through UTM data.
- Displaying onboarding insights through performance dashboards.

---

## 💡 Project Overview

**Existing Manual Process:**
1. A CA submits the *New Joinee Form* on the IAC website.  
2. The team manually generates a UTM link and sends it through email.

**Automated Solution (This Project):**
- When a new CA registers, the system automatically:
  1. Generates a UTM tracking link.
  2. Sends a customized welcome email to the CA’s provided email ID.
  3. Logs submission and tracking data into a PostgreSQL database.

This automation streamlines CA onboarding, saves time, and minimizes human error.

---

### 🛠️ Technology Stack

The following core, enterprise-level technologies underpin this application:

| Category | Technology | Purpose / Role in Project |
| :--- | :--- | :--- |
| **Backend Framework** | **Spring Boot** | [cite_start]Primary framework for building the application service[cite: 12, 18, 30]. |
| **Programming Language** | **Java** | [cite_start]Core language for business logic and development[cite: 24, 30]. |
| **Database** | **PostgreSQL** | [cite_start]Primary relational database for data storage[cite: 18]. |
| **Data Access** | **JDBC** | [cite_start]Used for connecting Java applications to the PostgreSQL database[cite: 24]. |
| **Frontend/UI** | **Thymeleaf** | [cite_start]Templating engine used for configuring view templates and navigation[cite: 42]. |
| **Protocols** | **SMTP, APIs** | [cite_start]Protocols and patterns for email transmission [cite: 30] [cite_start]and server communication[cite: 18]. |
| **VCS** | **Git & GitHub** | [cite_start]Used for version control and collaborative development[cite: 48]. |

---

### ⚙️ Installation and Setup

Follow these steps to set up a local development environment for the Email Service Application:

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/hassanrafai1707/Email.git](https://github.com/hassanrafai1707/Email.git)
    cd Email
    ```
2.  **Database Configuration:**
    * Ensure **PostgreSQL** is installed and running.
    * Create a dedicated database (e.g., `email_db`).
    * Update the database connection details (URL, username, password) in the `application.properties` or `application.yml` file. [cite_start]This includes the setup and optimization configured during development[cite: 24].
3.  **Run the Application:**
    * Open the project in your preferred Java IDE (IntelliJ IDEA, Eclipse).
    * Run the main Spring Boot application class.
    * Using Terminal :                                                                                                                                                                                                     mvn clean install                                                                                                                                                                                                   mvn spring-boot:run

[cite_start]The application server is configured to start on port **8081**[cite: 42].

---

### 🧑‍💻 Development and Learning Timeline

The project's development path focused on phased, incremental learning and feature implementation:

| Week | Key Focus Areas and Achievements |
| :--- | :--- |
| **Week 01** | [cite_start]Induction, career/industry training, and initiation of the live project[cite: 6]. |
| **Week 02** | [cite_start]Problem statement research and foundational study of the **Spring Boot** framework[cite: 12]. |
| **Week 03** | [cite_start]Core learning: **Client-Server Architecture, API** design, and initial exploration of databases (**PostgreSQL/MySQL**)[cite: 18]. |
| **Week 04** | [cite_start]Hands-on implementation of **PostgreSQL integration** with Java applications using **JDBC** for CRUD operations[cite: 24]. |
| **Week 05** | [cite_start]Learned and implemented **Email Sending functionality** using **SMTP** and Spring Boot's mailing services[cite: 30]. |
| **Week 06** | [cite_start]Finalized email functionality, applied `@GeneratedValue` for entity ID control, and designed user **confirmation/success workflows**[cite: 36]. |
| **Week 07** | [cite_start]Major interface updates: Redesigned the **Login/Dashboard**, configured **Thymeleaf** navigation, and updated the application port to **8081**[cite: 42]. |
| **Week 08** | [cite_start]Mastery of **Git and GitHub** distributed version control systems, focusing on branching, merging, and conflict resolution[cite: 48]. |
| **Week 09** | [cite_start]**Final Project Touches:** Feature review, interface refinement, and development of a dedicated **student performance page**[cite: 54]. |

---

### 🤝 Contributing

Contributions are welcome! If you have suggestions for improving this project or find any issues, please feel free to:

1.  **Fork** the repository.
2.  Create a new feature branch (`git checkout -b feature/AmazingFeature`).
3.  Commit your changes (`git commit -m 'Add AmazingFeature'`).
4.  Push to the branch (`git push origin feature/AmazingFeature`).
5.  Open a **Pull Request**.

## 🗂️ Project Structure
Email/
├── src/
│ ├── main/
│ │ ├── java/com/EmailtestApplication/EmailtestApplication/
│ │ │ ├── Controller/ # REST & Web Controllers
│ │ │ ├── Model/ # Entity Classes
│ │ │ ├── Repository/ # Database Interfaces
│ │ │ ├── Service/ # Business Logic
│ │ │ └── EmailtestApplication.java
│ │ └── resources/
│ │ ├── templates/ # Thymeleaf HTML Files
│ │ ├── application.properties
│ │ └── static/
├── pom.xml # Maven Dependencies
└── README.md
### 📚 References

Java Mail API Documentation
Spring Boot Documentation
PostgreSQL Docs
Cloud Counselage Website
GitHub Repository
Mentor: Prof. Madhavi M.
###  👨‍💻 Author

Hassan Abdul Rahim Patel
Linkin Profile:-
https://www.linkedin.com/in/hassan-rafai-270399352/
Diploma in Computer Engineering – Vidyalankar Polytechnic
Roll No: 23203C0055
📅 June–August 2025 | Cloud Counselage IAC Internship
