package LLDObserverPattern;

public class WeatherClass implements ObserverInterface {

    private String name ;

    public WeatherClass(String name) {
        this.name = name;
    }


    public void update() {
        System.out.println(name );
        System.out.println("Recieved the data");
    }


}
