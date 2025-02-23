package LLDNotificationService;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        PaymentFailureObserver failureObserver = new PaymentFailureObserver();

        paymentProcessor.addObserver(failureObserver);

        int userId = 1;
        double amount = 500.00;

        boolean paymentSuccess = paymentProcessor.processPayment(userId, amount);
        if (paymentSuccess) {
            System.out.println("Payment successful for user " + userId);
        }
    }
}
