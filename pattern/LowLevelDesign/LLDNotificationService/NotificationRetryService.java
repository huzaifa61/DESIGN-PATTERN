package LLDNotificationService;

import java.util.*;

public class NotificationRetryService {
    private static final int MAX_RETRIES = 3;
    private static final Map<Integer, Integer> retryCount = new HashMap<>();

    public static void retryFailedNotification(NotificationRequest request) {
        int attempts = retryCount.getOrDefault(request.getUserId(), 0);

        if (attempts >= MAX_RETRIES) {
            System.out.println("Max retries reached for user " + request.getUserId());
            return;
        }

        System.out.println("Retrying notification for user " + request.getUserId());
        retryCount.put(request.getUserId(), attempts + 1);

        NotificationSender sender = NotificationSenderFactory.getSender(request.getChannelType());
        boolean success = sender.sendNotification(request);

        if (!success) {
            retryFailedNotification(request);
        }
    }
}
