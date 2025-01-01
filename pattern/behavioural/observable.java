package behavioural;

import java.util.*;

interface observableInterface {

    void addObserver(Observer obj);
    void removeObserver(Observer obj);
    void notifyObserver();
    void setData(String data);
}

 class observable implements observableInterface{
     private List<Observer> observers = new ArrayList<>();
     private String data;

     @Override
     public void addObserver(Observer obj) {
         observers.add(obj);
     }

     @Override
     public void removeObserver(Observer obj) {
         observers.remove(obj);
     }

     @Override
     public void notifyObserver() {
         for (Observer observer : observers) {
             observer.update(data); // Notify all observers with the updated data
         }



     }

     @Override
     public void setData(String data) {
         this.data = data; // Set the new data
         notifyObserver(); // Notify observers about the change
     }
 }

 interface Observer{
    void  update(String data);
}

   class ObserverConcrete implements Observer{

    String name;

      ObserverConcrete(String name){
          this.name=name;

      }

      @Override
      public void update(String data) {
          System.out.println(name+" Recieved Updated Data "+data);
       }
   }


     class ObserverExample{
    public static void  main(String args[]){
        observable observerExample = new observable();

        Observer ob1 = new ObserverConcrete("Observer 1");
        Observer ob2 = new ObserverConcrete("Observer 2");

        observerExample.addObserver(ob1);
        observerExample.addObserver(ob2);

        System.out.println("Setting data to 'Hello, Observers!'");
        observerExample.setData("Hello, Observers got new info!");

        // Remove one observer and update data again
        observerExample.removeObserver(ob2);
        System.out.println("Setting data to 'Goodbye, Observers!'");
        observerExample.setData("Goodbye, Observers!");

    }
     }