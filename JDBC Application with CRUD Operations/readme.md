# 🍽️ Restaurant Database Management using JDBC

A simple Java application that demonstrates database connectivity using JDBC with MySQL.  
This project performs complete CRUD operations on restaurant and menu data.

📁 Part of the [Programming-in-Java](https://github.com/Kashish811/Programming-in-Java) repository.

---

## 📌 Features

- Create and manage a MySQL database using Java
- Two relational tables:
  - `Restaurant`
  - `MenuItem` (linked using foreign key)
- Insert multiple records into both tables
- Retrieve data using conditions and JOIN queries
- Update records based on specific criteria
- Delete records using pattern matching
- Display results in tabular format using `ResultSet`

---

## 🏗️ Project Structure

```
JDBC Application with CRUD Operations/
└── FoodManagementSystem.java
```

---

## 🧠 Concepts Used

- JDBC (Java Database Connectivity)
- SQL (DDL + DML operations)
- `PreparedStatement` & `Statement`
- `ResultSet` handling
- Relational Database (Foreign Key)
- Exception Handling
- Basic MySQL operations

---

## ⚙️ Functionalities Implemented

- Insert 10 records into `Restaurant` and `MenuItem` tables
- Fetch menu items where price ≤ 100
- Retrieve items available in **"Cafe Java"** (using JOIN)
- Update menu prices (≤100 → 200)
- Delete items whose names start with `'P'`
- Display all results in structured tabular format

---

## 🚀 How to Run

**1. Clone the repository:**
```bash
git clone https://github.com/Kashish811/Programming-in-Java.git
```

**2. Navigate to the project folder:**
```bash
cd "Programming-in-Java/JDBC Application with CRUD Operations"
```

**3. Compile the program (with MySQL Connector):**
```bash
javac -cp ".;mysql-connector-j-9.6.0.jar" FoodManagementSystem.java
```

**4. Run the program:**
```bash
java -cp ".;mysql-connector-j-9.6.0.jar" FoodManagementSystem
```

---

## 🛠️ Requirements

| Requirement | Details |
|---|---|
| Java | JDK 8 or above |
| Database | MySQL Server |
| Driver | MySQL Connector/J (JDBC Driver) |

---

## ⚠️ Notes

- Ensure MySQL server is running before execution
- Update database **username** and **password** in the source code
- Tables are created automatically via JDBC on first run
- Existing tables may need to be dropped before re-running

---

## 🎯 Learning Outcome

This project helps in understanding how Java interacts with databases using JDBC and how CRUD operations are implemented in real-world applications.

---

> ⭐ This is a console-based academic project focused on database connectivity concepts.
