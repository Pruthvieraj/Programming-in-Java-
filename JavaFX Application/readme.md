# 🍽️ Food Database Management System

This repository contains a Java-based **Food Database Management System** built with **JavaFX** for the GUI and **MySQL** for backend data storage. It demonstrates full **CRUD operations** on a relational database through an interactive desktop application.

---

## ✨ Features

- 🖥️ **JavaFX GUI**: Clean, multi-panel desktop interface with a central home menu and dedicated panels for each entity.
- 🗄️ **MySQL Integration**: Connects to a live MySQL database, auto-creates the database and tables on first run.
- 🍴 **Restaurant Management**: Add, view, update, and delete restaurant records with ID, Name, and Address fields.
- 🧾 **Menu Item Management**: Manage food items linked to restaurants via a foreign key, with ID, Name, Price, and Restaurant ID.
- 🔗 **Relational Data**: Enforces a `MenuItem → Restaurant` foreign key relationship at the database level.

---

## 📂 File Structure

| File | Description |
|------|-------------|
| 🚀 `Main.java` | Entry point; initializes the DB connection, creates tables, and renders the home screen. |
| 🗄️ `DBHelper.java` | Utility class handling all JDBC operations — connect, create, insert, select, update, delete. |
| 🍴 `RestaurantPanel.java` | JavaFX panel for performing CRUD operations on the `Restaurant` table. |
| 🧾 `MenuPanel.java` | JavaFX panel for performing CRUD operations on the `MenuItem` table. |
| 📦 `mysql-connector-j-9_6_0.jar` | MySQL JDBC driver — required at compile and runtime. |

---

## 🛠️ Technical Overview

### Architecture

```
Main (JavaFX Application)
    ├── DBHelper          → All JDBC / SQL logic (static utility methods)
    ├── RestaurantPanel   → GUI + CRUD for Restaurant table
    └── MenuPanel         → GUI + CRUD for MenuItem table (FK → Restaurant)
```

### 🗄️ Database Schema

**Restaurant**
| Column  | Type         |
|---------|--------------|
| Id      | INT (PK)     |
| Name    | VARCHAR(100) |
| Address | VARCHAR(100) |

**MenuItem**
| Column | Type                    |
|--------|-------------------------|
| Id     | INT (PK)                |
| Name   | VARCHAR(100)            |
| Price  | DOUBLE                  |
| ResId  | INT (FK → Restaurant.Id)|

### ⚙️ DB Connection — `DBHelper`
On startup, `DBHelper.connect()` first connects to the MySQL server root, auto-creates `restaurant_db` if it doesn't exist, then returns a full connection. Tables are created with `IF NOT EXISTS` guards so re-runs are safe.

---

## 🔧 Prerequisites

- Java 11+ with **JavaFX SDK**
- **MySQL Server** running locally on port `3306`
- MySQL username: `root` — update the password in `DBHelper.java`:
  ```java
  static final String PASS = "your_password_here";
  ```

---

## 🚀 How to Run

> Replace `/path/to/javafx-sdk/lib` with your actual JavaFX SDK lib path.

**1. Navigate to the project directory:**
```bash
cd "Food Database Management System"
```

**2. Compile all source files:**
```bash
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp mysql-connector-j-9_6_0.jar *.java
```

**3. Run the application:**
```bash
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp .:mysql-connector-j-9_6_0.jar Main
```
> On Windows, replace `.:` with `.;` in the classpath.

---

## 🖥️ Application Flow

```
Home Screen
    ├── [Manage Restaurants] → RestaurantPanel (INSERT / SELECT ALL / UPDATE / DELETE)
    ├── [Manage Menu Items]  → MenuPanel       (INSERT / SELECT ALL / UPDATE / DELETE)
    └── [Exit]               → Closes DB connection and exits
```
