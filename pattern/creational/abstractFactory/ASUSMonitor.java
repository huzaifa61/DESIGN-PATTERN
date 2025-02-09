package creational.abstractFactory;

public class ASUSMonitor implements Monitor{
    @Override
    public void createMonitor() {
        System.out.println("ASUS Monitor");
    }
}
