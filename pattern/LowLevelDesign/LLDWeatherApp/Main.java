package LLDWeatherApp;

import LLDWeatherApp.Observable.IphoneObservableImpl;
import LLDWeatherApp.Observable.StockObservable;
import LLDWeatherApp.Observer.EmailNotify;
import LLDWeatherApp.Observer.NotificationAlertObserver;

public class Main {

    public static void main(String[] args) {

        StockObservable stockObservable = new IphoneObservableImpl();
        NotificationAlertObserver notificationAlertObserver = new EmailNotify("Subjecct","huz@shk@db.com");

        stockObservable.addObserver(notificationAlertObserver);
        stockObservable.setData(10);

    }
}
