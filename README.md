\# Employee Management System



Simple employee management app. Spring Boot REST API with a plain HTML/JS frontend.



\## Tech stack

\- Java 17, Spring Boot 3.3.0, Spring Data JPA

\- MySQL

\- Maven

\- HTML, CSS, JavaScript



\## How to run

1\. Install Java, Maven and MySQL.

2\. Create a database named `employee` in MySQL.

3\. Set your MySQL username and password in `src/main/resources/application.properties`.

4\. Start the app: `./mvnw spring-boot:run` (or run `HelloSpringBootApplication` in Eclipse).

5\. Open `index.html` with VS Code Live Server (http://127.0.0.1:5500).



\## API endpoints

| Method | URL | What it does |

|---|---|---|

| GET | /employee | List all employees |

| POST | /employee | Add an employee |

| PUT | /employee/{id} | Update an employee |

| DELETE | /employee/{id} | Delete an employee |

| POST | /register | Register a user |

| POST | /Login | Log in |

