package LLDNotificationService;

public class EmailNotificationSender implements NotificationSender {
    @Override
    public boolean sendNotification(NotificationRequest request) {
        System.out.println("Sending Email to user " + request.getUserId() + ": " + request.getMessage());
        return Math.random() > 0.2; // Simulating 80% success rate
    }
}
