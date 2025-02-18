# Employee Management System (EMS)

## 📌 Project Overview
The **Employee Management System (EMS)** is a full-stack web application that allows users to manage employee records efficiently. It provides features such as listing employees, adding new employees, updating employee details, and deleting records. The system is built using **React.js** for the frontend, **Spring Boot** for the backend, and **MySQL** as the database.

## 🚀 Features
- 📋 View the list of employees
- ➕ Add new employees
- ✏️ Edit employee details
- 🗑️ Delete employees
- 📱 Fully responsive UI with Bootstrap
- 🔗 REST API integration with Spring Boot
- 🛢️ Persistent data storage using MySQL

## 🛠️ Tech Stack
- **Frontend**: React.js, React Router, Bootstrap
- **Backend**: Spring Boot, Spring Data JPA
- **Database**: MySQL
- **Styling**: Bootstrap 5, CSS
- **State Management**: React Hooks (useState, useEffect)

## 📂 Project Structure
```
EMS-Project/
│── frontend/
│   ├── public/
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── App.js
│   │   ├── index.js
│── backend/
│   ├── src/main/java/com/ems/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── model/
│   ├── src/main/resources/application.properties
│── package.json (Frontend)
│── pom.xml (Backend)
│── README.md
```

## 🔧 Installation & Setup
### 1️⃣ Clone the repository
```sh
git clone https://github.com/your-username/ems-project.git
cd ems-project
```

### 2️⃣ Backend Setup (Spring Boot + MySQL)
#### Configure MySQL Database
Update `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ems_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

#### Install Dependencies & Run Server
```sh
cd backend
mvn clean install
mvn spring-boot:run
```

### 3️⃣ Frontend Setup (React)
```sh
cd frontend
npm install
npm start
```

The frontend will be available at **http://localhost:3000/** and the backend at **http://localhost:8080/**.

## 🏗️ Usage
1. Start the backend (Spring Boot) first.
2. Start the frontend (React) and access the application.
3. Navigate to `Employees` to view the list of employees.
4. Click `Add Employee` to add a new record.
5. Use the `Edit` button to update details.
6. Click `Delete` to remove an employee.

## 🛠️ Fixing Bootstrap Navbar Issues
If the **Navbar toggle button** is not working, ensure that Bootstrap JS is properly included:

### ✅ Add Bootstrap and Popper.js
#### Option 1: Using CDN
Add this to `frontend/public/index.html` before `</body>`:
```html
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
```

#### Option 2: Using npm
```sh
npm install bootstrap
```
Import Bootstrap in `frontend/src/index.js`:
```js
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
```


---
🚀 **Developed by Sivasankari G R** | 💻 [My GitHub](https://github.com/sivasan2022)

