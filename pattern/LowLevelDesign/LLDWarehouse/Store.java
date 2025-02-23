package LLDWarehouse;


    public class Store implements Observer {
        private String name;
        private Warehouse warehouse;

        public Store(String name, Warehouse warehouse) {
            this.name = name;
            this.warehouse = warehouse;
            warehouse.registerObserver(this); // Auto-register with warehouse
        }

        @Override
        public void update(Warehouse warehouse) {
            if (this.warehouse == warehouse) { // Ensure correct warehouse
                System.out.printf("[%s] Warehouse inventory updated: %s%n",
                        name, warehouse.getInventory());
                // Add logic to sync store inventory here
            }
        }

        public void unsubscribe() {
            warehouse.removeObserver(this); // Stop receiving updates
        }
    }

