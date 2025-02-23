package LLDShoppingCart;

import java.util.List;

class Order {
    private int orderId;
    private List<CartItem> items;
    private double totalAmount;
    private String status;

    public Order(List<CartItem> items) {
        this.items = items;
        this.totalAmount = items.stream().mapToDouble(CartItem::getSubtotal).sum();
        this.status = "Pending";
    }

    public void placeOrder(PaymentStrategy paymentMethod) {
        paymentMethod.pay(totalAmount);
        this.status = "Completed";
    }
}
