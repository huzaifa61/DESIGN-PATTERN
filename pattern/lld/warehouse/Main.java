package warehouse;


    public class Main {
        public static void main(String[] args) {
            // Create warehouse and stores
            Warehouse warehouse = new Warehouse();
            Store store1 = new Store("Store A", warehouse);
            Store store2 = new Store("Store B", warehouse);

            // Add inventory (triggers notifications)
            warehouse.addInventory("Laptop", 50);
            warehouse.addInventory("Mouse", 200);

            // Output:
            // [Store A] Warehouse inventory updated: {Laptop=50, Mouse=200}
            // [Store B] Warehouse inventory updated: {Laptop=50, Mouse=200}
        }
    }

