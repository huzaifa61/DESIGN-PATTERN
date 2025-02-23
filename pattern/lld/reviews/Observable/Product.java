package reviews.Observable;

import parkinglot.observer.Observer;
import reviews.Observer.Supplier;

public interface Product {

    public void registerObserver(Supplier supplier);
    public void removeObserver(Supplier supplier);
    public void notifyObservers();
    public void setData(String ratings);
}
