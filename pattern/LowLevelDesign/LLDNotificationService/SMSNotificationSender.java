package LLDNotificationService;

public class SMSNotificationSender implements NotificationSender {
    @Override
    public boolean sendNotification(NotificationRequest request) {
        System.out.println("Sending SMS to user " + request.getUserId() + ": " + request.getMessage());
        return Math.random() > 0.3; // Simulating 70% success rate
    }
}
