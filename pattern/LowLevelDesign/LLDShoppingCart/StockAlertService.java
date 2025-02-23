package LLDShoppingCart;

class StockAlertService implements StockObserver {
    private String name;

    public StockAlertService(String name) {
        this.name = name;
    }

    @Override
    public void stockUpdated(Product product) {
        System.out.println("Stock Alert: " + name + " - Product " + product.getName() + " is now available with stock: " + product.getStock());
    }
}
