package LLDNotificationService;

public class NotificationSenderFactory {
    public static NotificationSender getSender(NotificationChannelType type) {
        switch (type) {
            case EMAIL:
                return new EmailNotificationSender();
            case SMS:
                return new SMSNotificationSender();
            default:
                throw new IllegalArgumentException("Invalid Notification Type");
        }
    }
}

