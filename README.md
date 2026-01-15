# Inventory Stock Management System (Java + JDBC)

## 📌 Project Description
This is a **console-based Inventory Stock Management System** developed using **Java and JDBC**.  
The project manages product inventory, handles **sales and purchases**, provides **low stock alerts**, and ensures **data consistency** using database transactions.

---

## ✨ Features
- View product details
- Sell products (decrease stock)
- Purchase products (increase stock)
- Low stock alerts
- Transaction management using `commit` and `rollback`
- Console-based application (no frontend)

---

## 🛠 Technologies Used
- Java
- JDBC
- MySQL
- GitHub

---

## 📂 Project Structure
src/
└── inventory_stock_management_project
    ├── DBConnection.java
    ├── Product.java
    ├── ProductDAO.java
    ├── InventoryService.java
    └── Main.java

---

## ▶ How to Run the Project
1. Create a MySQL database named `inventory_and_stock_management`
2. Create required tables (`products`, `stock_logs`)
3. Update database **username** and **password** in `DBConnection.java`
4. Run `Main.java`
5. Use the console menu to perform inventory operations

---

## 🧠 Key Concepts Implemented
- JDBC CRUD operations
- PreparedStatement
- DAO and Service layer architecture
- Transaction handling using `setAutoCommit(false)`
- Commit and rollback for data consistency

---

## 🎯 Learning Outcome
- Strong understanding of JDBC
- Hands-on experience with database transactions
- Real-world inventory and stock management logic
- Practical experience using GitHub

---

## 👨‍💻 Author
Madhusudanrao

