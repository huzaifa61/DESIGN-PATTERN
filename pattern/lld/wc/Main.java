package wc;

import wc.observable.Observable;
import wc.observable.ObservableInterface;

public class Main {

  //  ObservableInterface observerExample = new Observable();


    public static void main(String[] args) {

        ObservableInterface ob1 = new Observable();
        ObserverInterface ob2 = new weatherClass("Observer 2");

        ob1.addObserver(ob2);
        ob1.setData(10);
    }

//        observerExample(ob1);
//        observerExample.addObserver(ob2);
//
//        System.out.println("Setting data to 'Hello, Observers!'");
//        observerExample.setData("Hello, Observers got new info!");
//
//    // Remove one observer and update data again
//        observerExample.removeObserver(ob2);
//        System.out.println("Setting data to 'Goodbye, Observers!'");
//        observerExample.setData("Goodbye, Observers!");
}
