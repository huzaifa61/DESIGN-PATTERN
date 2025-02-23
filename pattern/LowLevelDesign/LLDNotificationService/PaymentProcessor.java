package LLDNotificationService;

import java.util.*;

public class PaymentProcessor {
    private List<PaymentFailureObserver> observers = new ArrayList<>();

    public void addObserver(PaymentFailureObserver observer) {
        observers.add(observer);
    }

    public boolean processPayment(int userId, double amount) {
        boolean success = Math.random() > 0.2; // Simulating 80% success rate
        if (!success) {
            notifyObservers(userId);
        }
        return success;
    }

    private void notifyObservers(int userId) {
        for (PaymentFailureObserver observer : observers) {
            observer.onPaymentFailure(userId);
        }
    }
}

