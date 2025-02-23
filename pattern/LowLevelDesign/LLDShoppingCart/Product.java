package LLDShoppingCart;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

class Product {
    private int productId;
    private String name;
    private double price;
    private int stock;
    private List<StockObserver> observers = new ArrayList<>();

    public Product(int productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void attach(StockObserver observer) {
        observers.add(observer);
    }

    public void detach(StockObserver observer) {
        observers.remove(observer);
    }

    public void updateStock(int newStock) {
        this.stock = newStock;
        notifyObservers();
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.stockUpdated(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }
}