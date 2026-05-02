# 🗃️ Inventory Manager System

This repository contains a Java-based **Inventory Manager System** designed to demonstrate three classic **Gang of Four (GoF) Design Patterns** working together in a real-world-inspired scenario.

---

## ✨ Features

- 🔒 **Singleton Pattern**: Ensures a single, globally accessible `InventoryManager` instance throughout the application lifecycle.
- 🔌 **Adapter Pattern**: Seamlessly integrates `LegacyItem` objects into the modern `Product`-based system without modifying existing code.
- 🔁 **Iterator Pattern**: Provides a clean, uniform way to traverse all inventory items regardless of their underlying type.

---

## 📂 File Structure

| File | Description |
|------|-------------|
| 📄 `Product.java` | The core interface defining the `displayDetails()` contract for all inventory items. |
| 📦 `NewProduct.java` | A modern product class implementing the `Product` interface directly. |
| 🏚️ `LegacyItem.java` | An older item class with its own `print()` method — incompatible with `Product`. |
| 🔌 `ProductAdapter.java` | The Adapter class that wraps a `LegacyItem` and makes it compatible with `Product`. |
| 🗄️ `InventoryManager.java` | The Singleton manager that stores and iterates over all products using a `List<Product>`. |
| 🚀 `MainApp.java` | The Driver class that wires everything together and runs the inventory display. |

---

## 🛠️ Technical Overview

### Architecture

The system uses a three-pattern architecture:

```
Product (Interface)
    ├── NewProduct       → implements Product directly
    └── ProductAdapter   → wraps LegacyItem, implements Product (Adapter Pattern)

InventoryManager         → Singleton, holds List<Product>, exposes Iterator
MainApp                  → Entry point, drives all operations
```

### 🔒 Singleton — `InventoryManager`
Only one inventory instance can exist. The `getInstance()` method returns the shared instance, preventing duplicate stores.

### 🔌 Adapter — `ProductAdapter`
`LegacyItem` has a `print()` method, but the system expects `displayDetails()`. `ProductAdapter` bridges this gap — no legacy code is modified.

### 🔁 Iterator — `returnInventory()`
`InventoryManager` exposes an `Iterator<Product>` so all products (new and legacy) can be traversed uniformly via a standard `while (itr.hasNext())` loop.

---

## 🚀 How to Run

**1. Navigate to the project directory:**
```bash
cd "Inventory Manager System"
```

**2. Compile all source files:**
```bash
javac Product.java LegacyItem.java NewProduct.java ProductAdapter.java InventoryManager.java MainApp.java
```

**3. Run the application:**
```bash
java MainApp
```

---

## 🖥️ Sample Output

```
===== INVENTORY DETAILS =====

[New Product] Tablet
----------------------------
[New Product] Wireless Earbuds
----------------------------
[New Product] External SSD
----------------------------
[Legacy Item]
Item ID      : 301
Description  : Old Printer Model A
----------------------------
[Legacy Item]
Item ID      : 302
Description  : CRT Display Unit
----------------------------
```
