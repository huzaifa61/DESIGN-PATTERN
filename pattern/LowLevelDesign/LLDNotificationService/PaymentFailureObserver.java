package LLDNotificationService;

public class PaymentFailureObserver {
    public void onPaymentFailure(int userId) {
        System.out.println("Payment failed for user " + userId);

        NotificationRequest request = new NotificationRequest(
                userId,
                "Your payment has failed. Please retry.",
                NotificationChannelType.EMAIL
        );

        NotificationRetryService.retryFailedNotification(request);
    }
}

