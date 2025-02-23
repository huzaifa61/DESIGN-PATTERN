package LLDNotificationService;

public class NotificationRequest {
    private int userId;
    private String message;
    private NotificationChannelType channelType;

    public NotificationRequest(int userId, String message, NotificationChannelType channelType) {
        this.userId = userId;
        this.message = message;
        this.channelType = channelType;
    }

    public int getUserId() { return userId; }
    public String getMessage() { return message; }
    public NotificationChannelType getChannelType() { return channelType; }
}
