package LLDPL;

import java.util.List;

public class NotificationService implements Observable{

    List<Observer> observers;
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setData(int data) {
        int previous  = data;
        if (previous==0 && data==0){
            notifyObservers();
        }
    }
}
