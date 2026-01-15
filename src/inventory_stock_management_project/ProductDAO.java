package inventory_stock_management_project;

import java.sql.*;

public class ProductDAO {

    // -------- FETCH PRODUCT BY ID --------
    public Product getProductById(int productId) throws Exception {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM products WHERE product_id = ?");
        ps.setInt(1, productId);

        ResultSet rs = ps.executeQuery();
        Product product = null;

        if (rs.next()) {
            product = new Product(
                rs.getInt("product_id"),
                rs.getString("product_name"),
                rs.getInt("quantity"),
                rs.getInt("reorder_level"),
                rs.getDouble("price")
            );
        }

        con.close();
        return product;
    }

    // -------- SALE --------
    public void sellProduct(int productId, int qty) throws Exception {

        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);

        try {
            PreparedStatement ps1 = con.prepareStatement(
                "UPDATE products SET quantity = quantity - ? WHERE product_id = ?");
            ps1.setInt(1, qty);
            ps1.setInt(2, productId);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(
                "INSERT INTO stock_logs VALUES (?, ?, ?, 'SALE', CURRENT_DATE)");
            ps2.setInt(1, getNextLogId(con));
            ps2.setInt(2, productId);
            ps2.setInt(3, -qty);
            ps2.executeUpdate();

            con.commit();
            System.out.println("✅ Sale successful");

        } catch (Exception e) {
            con.rollback();
            System.out.println("❌ Sale failed. Rolled back.");
        } finally {
            con.close();
        }
    }

    // -------- PURCHASE --------
    public void purchaseProduct(int productId, int qty) throws Exception {

        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);

        try {
            PreparedStatement ps1 = con.prepareStatement(
                "UPDATE products SET quantity = quantity + ? WHERE product_id = ?");
            ps1.setInt(1, qty);
            ps1.setInt(2, productId);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(
                "INSERT INTO stock_logs VALUES (?, ?, ?, 'PURCHASE', CURRENT_DATE)");
            ps2.setInt(1, getNextLogId(con));
            ps2.setInt(2, productId);
            ps2.setInt(3, qty);
            ps2.executeUpdate();

            con.commit();
            System.out.println("✅ Purchase successful");

        } catch (Exception e) {
            con.rollback();
            System.out.println("❌ Purchase failed. Rolled back.");
        } finally {
            con.close();
        }
    }

    // -------- LOW STOCK --------
    public void showLowStock() throws Exception {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT product_name, quantity FROM products WHERE quantity <= reorder_level");
        ResultSet rs = ps.executeQuery();

        System.out.println("\n⚠ LOW STOCK ITEMS");
        boolean found = false;

        while (rs.next()) {
            found = true;
            System.out.println(
                rs.getString("product_name") +
                " - " + rs.getInt("quantity") + " units");
        }

        if (!found) {
            System.out.println("All products are sufficiently stocked.");
        }

        con.close();
    }

    // -------- LOG ID GENERATOR --------
    private int getNextLogId(Connection con) throws Exception {

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT IFNULL(MAX(log_id),0) + 1 FROM stock_logs");
        rs.next();
        return rs.getInt(1);
    }
}


