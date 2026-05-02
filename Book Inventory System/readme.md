
# 📚 Book Inventory System

This repository contains a Java-based **Book Inventory System** designed to demonstrate core Object-Oriented Programming (OOP) principles, custom exception handling, and collection management using `ArrayList`.

---

##  Features

* **Object Creation**: Supports multiple constructors (Default, Parameterized, and Copy) for flexible data entry.
* **⚠️ Custom Exception Handling**: Prevents data entry errors using specialized exceptions for price and genre validation.
* **📊 Dynamic Data Management**: Uses `ArrayList` to store, merge, and manipulate book records efficiently.
* **🔍 Inventory Insights**:
* Automatic calculation of the **Average Price** across the entire inventory.
* Filtering logic to isolate and count specific categories like **"Classic"** books.



---

##  📂 File Structure

| File | Description |
| --- | --- |
| 📄 `Book.java` | The Blueprint class defining attributes, validation logic, and display methods. |
| ⚙️ `ArrayListOfBook.java` | The Driver class containing the `main` method and inventory logic. |
| 🚫 `InvalidPriceException.java` | Custom Exception thrown when a book price is negative. |
| 🚫 `InvalidBookGenreException.java` | Custom Exception thrown for unsupported genres. |

---

##  🛠️ Technical Overview

###  Architecture

The system follows a standard OOP structure where the `Book` class encapsulates data and the `ArrayListOfBook` class handles the execution logic.

###  ✅ Validation Logic

The system enforces strict data integrity during object instantiation:

* **Price Validation**: Checks if `price < 0` and throws an `InvalidPriceException` if true.
* **Genre Validation**: Restricts input to a whitelist: **"Classic"**, **"Fantasy"**, or **"Dystopian"**.

---

To fix the **How to Run** section for the **Book Inventory System**, you need to account for the specific folder structure shown in your GitHub repository. Since the files are nested within a folder, the commands should include the directory change and compile all related Java files.

---

##  🚀 How to Run

To run the **Book Inventory System**, follow these steps:

1. **Navigate to the project directory**:
```bash
cd "Book Inventory System"

```


2. **Compile the source files**:
```bash
javac Book.java ArrayListOfBook.java InvalidPriceException.java InvalidBookGenreException.java

```


3. **Run the application**:
```bash
java ArrayListOfBook

```



---
