-- Create Database
CREATE DATABASE IF NOT EXISTS inventory_and_stock_management;
USE inventory_and_stock_management;

-- Products Table
CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    reorder_level INT NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

-- Stock Logs Table
CREATE TABLE stock_logs (
    log_id INT PRIMARY KEY,
    product_id INT,
    quantity_change INT,
    action_type VARCHAR(20),
    log_date DATE,
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- Sample Data
INSERT INTO products VALUES
(1, 'Laptop', 20, 5, 55000.00),
(2, 'Mouse', 100, 20, 500.00),
(3, 'Keyboard', 60, 15, 1200.00);
