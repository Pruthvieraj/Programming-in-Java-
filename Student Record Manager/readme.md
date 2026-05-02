# 📊 Student Record Manager (CSV) in Java

A simple file-based Student Record Management System implemented in Java using CSV files. This project demonstrates core concepts of file handling, CRUD operations, and exception handling in Java.

📁 Part of the **Programming-in-Java** repository.

---

## 📌 Features

- Perform CRUD operations on a CSV file:
  - Insert new student records
  - Read and display records
  - Update existing data
  - Delete a student record
- Calculate percentage based on 5 subject marks
- Automatically update missing marks (`marks4` & `marks5`)
- Handle file operations using `BufferedReader` & `BufferedWriter`
- Demonstrate `IOException` handling
- Display outputs step-by-step in console

---

## 🏗️ Project Structure

```
Student Record Manager/
├── Students.csv
├── Insert.java
├── Update.java
├── Delete.java
├── CalcPercentage.java
└── Main.java
```

---

## 🧠 Concepts Used

- File Handling (`FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`)
- CSV Data Processing
- CRUD Operations
- Exception Handling (`IOException`)
- Arrays & String Manipulation
- Modular Programming (multiple classes)

---

## 🧾 Operations Performed

| Operation | Description |
|---|---|
| **CREATE** (Insert) | Adds new student records to CSV |
| **READ** | Displays CSV data in console |
| **UPDATE** | Updates missing marks (`marks4` & `marks5`) |
| **CALCULATE** | Computes percentage of each student |
| **DELETE** | Removes a student record by ID |

---

## 📊 CSV Format

```
studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage
```

---

## ⚙️ How to Run

1. Open project folder in VS Code / Terminal
2. Compile all files:
   ```bash
   javac *.java
   ```
3. Run the program:
   ```bash
   java Main
   ```

---

## 🖥️ Sample Output

```
--- INSERT OPERATION ---
Inserted 3 new students.

--- UPDATE OPERATION ---
Updated missing marks.

--- CALCULATE PERCENTAGE ---
Percentage calculated.

--- DELETE OPERATION ---
Deleted student with ID: 803

Exception demo: File not found
```

---

## 🚨 Exception Handling

The program handles:

- ❌ File not found
- ❌ Input/output errors during file operations
- ❌ Invalid or missing data in CSV

---

## ⭐ Notes

- This is a console-based academic project
- Designed for understanding Java file handling and CRUD operations
- CSV file is used instead of database for simplicity
- Can be extended using:
  - Database (MySQL)
  - GUI (JavaFX / Swing)
  - Web integration
