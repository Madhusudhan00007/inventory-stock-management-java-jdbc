package inventory_stock_management_project;

public class Product {

    private int productId;
    private String productName;
    private int quantity;
    private int reorderLevel;
    private double price;

    public Product(int productId, String productName,
                   int quantity, int reorderLevel, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
        this.price = price;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public double getPrice() {
        return price;
    }
}

