package inventory_stock_management_project;

public class InventoryService {

    private ProductDAO dao = new ProductDAO();

    public void viewProduct(int productId) throws Exception {
        Product p = dao.getProductById(productId);

        if (p != null) {
            System.out.println("\nProduct Details");
            System.out.println("ID: " + p.getProductId());
            System.out.println("Name: " + p.getProductName());
            System.out.println("Quantity: " + p.getQuantity());
            System.out.println("Price: " + p.getPrice());
        } else {
            System.out.println("❌ Product not found");
        }
    }

    public void sell(int productId, int qty) throws Exception {
        dao.sellProduct(productId, qty);
    }

    public void purchase(int productId, int qty) throws Exception {
        dao.purchaseProduct(productId, qty);
    }

    public void checkLowStock() throws Exception {
        dao.showLowStock();
    }
}


