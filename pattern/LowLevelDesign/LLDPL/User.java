package LLDPL;

public class User implements Observer {

    @Override
    public void update() {
        System.out.println("Recieved update");
    }
}
