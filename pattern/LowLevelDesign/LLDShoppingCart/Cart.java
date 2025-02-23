package LLDShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public void removeItem(Product product) {
        items.removeIf(item -> item.getProduct().equals(product));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(CartItem::getSubtotal).sum();
    }
}

