package weatherApp;

import weatherApp.Observable.IphoneObservableImpl;
import weatherApp.Observable.StockObservable;
import weatherApp.Observer.EmailNotify;
import weatherApp.Observer.NotificationAlertObserver;

public class Main {

    public static void main(String[] args) {

        StockObservable stockObservable = new IphoneObservableImpl();
        NotificationAlertObserver notificationAlertObserver = new EmailNotify("Subjecct","huz@shk@db.com");

        stockObservable.addObserver(notificationAlertObserver);
        stockObservable.setData(10);

    }
}
