# 👔 Employee Management System in Java

A simple Object-Oriented Employee Payroll System implemented in Java. This project demonstrates core OOP concepts like inheritance, abstract classes, method overriding, polymorphism, and custom exception handling.

📁 Part of the __Programming-in-Java__ repository.

---

## 📌 Features

* Define and manage multiple employee types
* Support for three employee categories:
  * Full-Time Employee (DEV / HR departments)
  * Contract Employee (hourly-based)
  * Manager (with travel & learning allowances)
* CTC (Cost to Company) calculation per employee type
* Department-based CTC logic for full-time employees
* Custom exception handling:
  * Invalid employee name or ID
  * Invalid salary/contract values
* Tabular console output of employee compensation details

---

## 🏗️ Project Structure

```
Employee Management System/
├── Employee.java
├── FullTimeEmployee.java
├── ContractEmployee.java
├── Manager.java
├── InvalidEmployeeException.java
└── Main.java
```

---

## 🧠 Concepts Used

* Abstract Classes & Methods (`Employee`)
* Inheritance (`FullTimeEmployee`, `ContractEmployee` → `Employee`; `Manager` → `FullTimeEmployee`)
* Method Overriding (`calculateCTC()`, `getType()`, etc.)
* Polymorphism (Employee array holding different types)
* Exception Handling (Custom `InvalidEmployeeException` + `IllegalArgumentException`)
* Encapsulation

---

## 🧾 Employee Types & CTC Logic

| Type | Code | CTC Formula |
|---|---|---|
| Full-Time (DEV) | `FT` | Salary + Bonus |
| Full-Time (HR) | `FT` | Salary + ₹15,000 |
| Contract | `CON` | Hours Worked × Rate per Hour |
| Manager | `MGR` | Salary + Bonus + Travel + Learning Allowance |

---

## ⚙️ How to Run

1. Clone the main repository:

```
git clone https://github.com/Kashish811/Programming-in-Java.git
```

2. Navigate to this project folder:

```
cd "Programming-in-Java/Employee Payroll System"
```

3. Compile the code:

```
javac Main.java
```

4. Run the program:

```
java Main
```

---

## 🚨 Exception Handling

The system handles:

* ❌ Empty or null employee name
* ❌ Non-positive employee ID
* ❌ Negative salary, insurance, bonus, or stock values
* ❌ Negative hours worked or rate per hour (contract employees)
* ❌ Negative travel or learning allowances (managers)

---

## ⭐ Notes

* This is a console-based academic project
* Designed for learning concepts in Java
* Can be extended with a database, GUI, or full HR management features
