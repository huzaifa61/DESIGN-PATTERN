package weatherApp.Observable;

import weatherApp.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable {

    public List<NotificationAlertObserver> observerList;
    private int stockCount;

    public  IphoneObservableImpl() {
        this.observerList = new ArrayList<>();
        this.stockCount = 0;
    }

    @Override
    public void addObserver(NotificationAlertObserver observer) {
        observerList.add(observer);

    }

    @Override
    public void removeObserver(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(NotificationAlertObserver observer : observerList) {
            observer.update();
        }

    }

    @Override
    public void setData(int newCount) {
        int previousStock = stockCount;
        stockCount += newCount; // Assuming stockAdded is the amount added to current stock
        if (previousStock == 0 && stockCount > 0) {
            notifyObservers(); // Notify when stock becomes available
        }

    }

}
