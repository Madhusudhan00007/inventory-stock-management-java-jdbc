package inventory_stock_management_project;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Create and return connection
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/inventory_and_stock_management",
            "root",
            "password"   // change if needed
        );
    }
}


