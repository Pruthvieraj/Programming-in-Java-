# 📐 Vector Operations Program

This repository contains a Java-based **Vector Operations Program** designed to perform mathematical operations on 2D and 3D vectors while demonstrating custom exception handling and defensive programming.

---

##  Features

* **Vector Support**: Strictly handles **2D and 3D vectors** using array-based components.
* **Mathematical Operations**:
* **Addition**: Computes the sum of two vectors of the same dimension.
* **Subtraction**: Computes the difference between two vectors of the same dimension.
* **Dot Product**: Calculates the scalar product of two vectors.


* **⚠️ Custom Exception Handling**: Utilizes a specialized `VectorException` to manage:
* Invalid dimensions (anything other than 2 or 3).
* Dimension mismatches during operations (e.g., adding a 2D vector to a 3D vector).


* **🛡️ Defensive Programming**: Uses defensive copying of components to ensure internal vector state remains immutable from external array changes.

---

##  📂 File Structure

| File | Description |
| --- | --- |
| 📄 `Vector.java` | The core class defining vector attributes, math logic, and validation. |
| ⚙️ `VectorOperations.java` | The Driver class that handles user input and executes vector math. |
| 🚫 `VectorException.java` | Custom Exception class for vector-specific error handling. |

---

##  🛠️ Technical Overview

###  Architecture

The program is built around the `Vector` class, which encapsulates a `double[]` array representing vector components. The `VectorOperations` class serves as the user interface, prompting for dimensions and components before performing calculations.

###  ✅ Validation Logic

The system enforces strict mathematical rules:

* **Dimension Check**: Constructors and input loops verify that vectors are exactly 2D or 3D.
* **Match Check**: Operations like `add`, `subtract`, and `dotProduct` verify that both vectors share the same length before proceeding.

---
Based on your file structure, the **How to Run** section needs to be updated to ensure you are in the correct directory before compiling and running the code.

---

##  🚀 How to Run

To run the **Vector Operations Program**, follow these steps:

1. **Navigate to the project directory**:
```bash
cd "Vector Operations Program"

```


2. **Compile the source files**:
```bash
javac Vector.java VectorException.java VectorOperations.java

```


3. **Run the application**:
```bash
java VectorOperations

```






