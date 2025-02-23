package LLDObserverPattern.observable;

import LLDObserverPattern.ObserverInterface;

import java.util.ArrayList;
import java.util.List;

public class Observable implements ObservableInterface {

    List<ObserverInterface> observerList ;
    int counter;

    public Observable() {
        this.observerList = new ArrayList<>();
        this.counter = 0;

    }

    @Override
    public void addObserver(ObserverInterface observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(ObserverInterface observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ObserverInterface observer : observerList) {
            observer.update();
        }
    }

    @Override
    public void setData(int data) {
        int index = counter;
        int stock = index+data;

        if(stock>0 && index==0){
            notifyObservers();
        }
    }


}
