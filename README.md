# 📘 Book Borrowing System

This is a mini Spring Boot project designed to test and demonstrate understanding of Spring Boot, JPA, REST APIs, and database interaction.

---

## 💡 Problem Statement
Build a backend service for managing books and their borrowing status in a small library. Users (borrowers) can borrow and return books. The system tracks borrowing records and maintains availability.

---

## 🧱 Tech Stack
- Java 21+
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (in-memory)
- Maven

---

## 🚀 How to Run

1. Clone the repository
2. Run with your favorite IDE or via CLI:
```bash
mvn spring-boot:run
```
3. Visit H2 Console (optional):
```
http://localhost:8080/h2-console
```
- JDBC URL: `jdbc:h2:mem:mini_library`
- User: `dev`, Password: `dev`

---

## 📡 API Endpoints

### 📘 Book
| Method | Endpoint        | Description           |
|--------|------------------|-----------------------|
| POST   | /books           | Add a new book        |
| GET    | /books           | Get all books         |
| GET    | /books?available=true | Get only available books |

### 👤 Borrower
| Method | Endpoint           | Description              |
|--------|---------------------|--------------------------|
| POST   | /borrowers          | Add a new borrower       |
| GET    | /borrowers/{id}/records | Get borrowing history    |

### 🔁 Borrowing
| Method | Endpoint   | Description         |
|--------|-------------|---------------------|
| POST   | /borrow     | Borrow a book       |
| POST   | /return     | Return a borrowed book |

---

## 🧪 Example Borrow Request
```http
POST /borrow
?bookId=1&borrowerId=2
```

## ✅ Validation Rules
- A book cannot be borrowed if it is not available.
- A book must be returned before it can be borrowed again.
- DTOs and input validation (`@Valid`, `@NotNull`)
- Filtering books by availability
---

## ✨ Bonus Features (Optional)
- Error handling for missing entities or unavailable books
- Swagger/OpenAPI documentation

---

## 📚 Evaluation Tips (for Interviewers)
Check the candidate's:
- Understanding of JPA relationships (`@ManyToOne`)
- Use of transactions and consistency
- RESTful design and error handling
- Code clarity and modularity
- Use of filtering, search, and clean logic separation
---

Happy coding! 🎉
