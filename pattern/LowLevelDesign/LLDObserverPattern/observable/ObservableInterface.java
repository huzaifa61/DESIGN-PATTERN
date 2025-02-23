package LLDObserverPattern.observable;

import LLDObserverPattern.ObserverInterface;

public interface ObservableInterface {
    public void addObserver(ObserverInterface observer);
    public void removeObserver(ObserverInterface observer);
    public void notifyObservers();
    public void setData(int data);
}
