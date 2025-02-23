package wc;

public class weatherClass implements ObserverInterface {

    private String name ;

    public weatherClass(String name) {
        this.name = name;
    }


    public void update() {
        System.out.println(name );
        System.out.println("Recieved the data");
    }


}
