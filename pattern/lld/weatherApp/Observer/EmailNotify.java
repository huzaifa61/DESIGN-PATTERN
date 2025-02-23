package weatherApp.Observer;

public class EmailNotify implements NotificationAlertObserver {

    public String subject;
    public String emailId;

    public  EmailNotify(String subject, String emailId) {
        this.subject = subject;
        this.emailId = emailId;
    }

    @Override
    public void update() {
        System.out.println("Email Notification Alert sent ");
    }
}
