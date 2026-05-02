import java.util.Iterator;

public class MainApp {

    public static void main(String[] args) {

        // Get Singleton instance
        InventoryManager manager = InventoryManager.getInstance();

        // Add new products
        manager.addProduct(new NewProduct("Tablet"));
        manager.addProduct(new NewProduct("Wireless Earbuds"));
        manager.addProduct(new NewProduct("External SSD"));

        // Add legacy items using Adapter
        LegacyItem item1 = new LegacyItem(301, "Old Printer Model A");
        LegacyItem item2 = new LegacyItem(302, "CRT Display Unit");

        manager.addProduct(new ProductAdapter(item1));
        manager.addProduct(new ProductAdapter(item2));

        // Iterate using Iterator
        System.out.println("\n===== INVENTORY DETAILS =====\n");

        Iterator<Product> itr = manager.returnInventory();

        while (itr.hasNext()) {
            Product product = itr.next();
            product.displayDetails();
            System.out.println("----------------------------");
        }
    }
}