
# Library Management System

A backend-focused library management system built with Spring Boot, PostgreSQL, and JWT authentication. Supports role-based access for admins and users, allowing book and library management, and book borrowing functionality.

## Technologies Used

- **Backend**: Spring Boot, Spring Data JPA, Spring Security
- **Database**: PostgreSQL
- **Authentication**: JWT (JSON Web Tokens)
- **Build Tool**: Maven
- **Validation**: Spring Validation

## Features

- **Role-Based Authentication (JWT)**
    - Admins and users have different access levels.
    - Secure API endpoints using JWT tokens.
- **Book Management**
    - Admins can add, update, delete, and retrieve books.
    - Users can view available books.
- **Library Management**
    - Admins can create and update library details.
- **Borrowing System**
    - Users can borrow books, which are tracked and visible to admins.
- **Input Validation**
    - Ensures valid data for API requests using Spring Validation.

## Getting Started

### Prerequisites

- Java 21 LTS
- Maven 3.8+
- PostgreSQL 14+
- IntelliJ IDEA (Community Edition recommended)
- Postman or curl for API testing

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/saadahmedbd/library-management-system.git

**2.Set Up PostgreSQL Database**

* Open pgAdmin and create a new database named library_management_system.

* Update the database credentials in src/main/resources/application.properties.

**3.Configure Application Properties**

Edit src/main/resources/application.properties:

* spring.datasource.url=jdbc:postgresql://localhost:5432/library_management_system
* spring.datasource.username=postgres
* spring.datasource.password=saadahmed@#7
* spring.jpa.hibernate.ddl-auto=update


**API Endpoints**
* Method	Endpoint	Description	Role Required
* POST	/api/auth/signup	Register a new user	PUBLIC
* POST	/api/auth/login	Authenticate and get JWT token	PUBLIC
* POST	/api/books	Add a new book	ADMIN
* GET	/api/books	Get all books	USER, ADMIN
* PUT	/api/books/{id}	Update a book by ID	ADMIN
* DELETE	/api/books/{id}	Delete a book by ID	ADMIN
* POST	/api/libraries	Add a new library	ADMIN
* PUT	/api/libraries/{id}	Update a library by ID	ADMIN
* POST	/api/borrow/{bookId}	Borrow a book	USER
* GET	/api/borrow/records	View all borrowing records	ADMIN

for better understanding, see controller 

**Security (JWT Authentication)**
* Sign Up: Send a POST request to /api/auth/signup with username, password, and role (ADMIN/USER).

* Login: Send a POST request to /api/auth/login to receive a JWT token

**Dependencies**
* Spring Web
* Spring Security

* Spring Data JPA

* Lombok

* PostgreSQL Driver

JJWT (JSON Web Token)

* jjwt-api

* jjwt-impl

* jjwt-jackson

* Spring Validation