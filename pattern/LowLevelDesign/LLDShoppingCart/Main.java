package LLDShoppingCart;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create Products
        Product laptop = new Product(1, "Laptop", 50000, 10);
        Product phone = new Product(2, "Smartphone", 30000, 5);

        // Create Stock Observer
        StockObserver emailService = new StockAlertService("Email Service");
        laptop.attach(emailService);
        phone.attach(emailService);

        // User adds products to cart
        CartManager cartManager = CartManager.getInstance();
        Cart userCart = cartManager.getCart(101);
        userCart.addItem(laptop, 1);
        userCart.addItem(phone, 2);

        System.out.println("Total Cart Value: ₹" + userCart.calculateTotal());

        // Apply Discount
        PercentageDiscount discountedCart = new PercentageDiscount(userCart, 10);
        System.out.println("Total after 10% discount: ₹" + discountedCart.getDiscountedTotal());

        // Place Order
        Order order = new Order(Arrays.asList(new CartItem(laptop, 1), new CartItem(phone, 2)));
        PaymentStrategy paymentMethod = PaymentFactory.getPaymentMethod("creditcard");
        order.placeOrder(paymentMethod);

        // Simulating Stock Update
        laptop.updateStock(8);
    }
}

