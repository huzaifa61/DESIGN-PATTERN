package LLDWeatherApp.Observable;

import LLDWeatherApp.Observer.NotificationAlertObserver;

public interface StockObservable {
    public void addObserver(NotificationAlertObserver observer);
    public void removeObserver(NotificationAlertObserver observer);
    public void notifyObservers();
    public void setData(int stockAdded);
}
