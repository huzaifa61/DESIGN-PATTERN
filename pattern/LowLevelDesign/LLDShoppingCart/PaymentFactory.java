package LLDShoppingCart;

class PaymentFactory {
    public static PaymentStrategy getPaymentMethod(String method) {
        switch (method.toLowerCase()) {
            case "creditcard":
                return new CreditCardPayment();
//            case "paypal":
//                return new PayPalPayment();
            default:
                throw new IllegalArgumentException("Invalid payment method");
        }
    }
}