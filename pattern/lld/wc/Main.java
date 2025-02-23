package wc;

import wc.observable.Observable;
import wc.observable.ObservableInterface;

public class Main {

  //  ObservableInterface observerExample = new Observable();


    public static void main(String[] args) {

        ObservableInterface observableInterface = new Observable();
        ObserverInterface observerInterface = new WeatherClass("Observer 2");
        ObserverInterface observerInterface2 = new WeatherClass("Observer 3");

        observableInterface.addObserver(observerInterface);
        observableInterface.addObserver(observerInterface2);
        observableInterface.setData(10);

      // observableInterface.setData(0);

       // observableInterface.setData(100);
    }

}
