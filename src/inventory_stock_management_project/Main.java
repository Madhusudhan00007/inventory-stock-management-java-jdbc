package inventory_stock_management_project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        InventoryService service = new InventoryService();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== INVENTORY STOCK MANAGEMENT =====");
            System.out.println("1. View Product");
            System.out.println("2. Sell Product");
            System.out.println("3. Purchase Product");
            System.out.println("4. Low Stock Alert");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    service.viewProduct(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Product ID: ");
                    int sellId = sc.nextInt();
                    System.out.print("Quantity Sold: ");
                    int sellQty = sc.nextInt();
                    service.sell(sellId, sellQty);
                    break;

                case 3:
                    System.out.print("Product ID: ");
                    int buyId = sc.nextInt();
                    System.out.print("Quantity Purchased: ");
                    int buyQty = sc.nextInt();
                    service.purchase(buyId, buyQty);
                    break;

                case 4:
                    service.checkLowStock();
                    break;

                case 5:
                    System.out.println("Exiting application...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

