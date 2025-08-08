📚 Book Management System
A full-stack book management app with:

Backend: Spring Boot REST API

Frontend: React with Vite

🛠 Tech Stack
Backend: Java 17, Spring Boot, Spring Data JPA, MySQL (or H2), Maven

Frontend: React.js, Vite, Axios, React Router

🚀 Backend Setup
Clone repo and navigate to backend folder:

bash
Copy code
git clone https://github.com/bramhadandiswapnil/BookManagementSystem.git
cd BookManagementSystem/backend
Configure database in src/main/resources/application.properties:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/book_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
Run backend app:

bash
Copy code
./mvnw spring-boot:run
API available at http://localhost:8080.

🌐 Frontend Setup (React + Vite)
Navigate to frontend folder:

bash
Copy code
cd ../frontend
Install dependencies:

bash
Copy code
npm install
Start the development server:

bash
Copy code
npm run dev
Frontend available at http://localhost:5173.

⚙️ Usage
View books list (using BookList.jsx component)

Add, edit, delete books

Frontend calls backend API via Axios

🔗 API Endpoints
Method	Endpoint	Description
GET	/books	Get all books
POST	/books	Add a new book
PUT	/books/{id}	Update a book
DELETE	/books/{id}	Delete a book

📦 Axios Example (src/services/bookService.js)
js
Copy code
import axios from "axios";

const API_BASE = "http://localhost:8080/books";

export const getAllBooks = () => axios.get(API_BASE);
export const getBookById = (id) => axios.get(`${API_BASE}/${id}`);
export const addBook = (book) => axios.post(API_BASE, book);
export const updateBook = (id, book) => axios.put(`${API_BASE}/${id}`, book);
export const deleteBook = (id) => axios.delete(`${API_BASE}/${id}`);
🤝 Cross-Origin Requests (CORS)
Make sure your Spring Boot backend enables CORS for the frontend origin (http://localhost:5173):

java
Copy code
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class BookController {
    // Your endpoints
}
🙋‍♂️ Author
Swapnil Bramhadandi
GitHub

📄 License
MIT License

