package creational.abstractFactory;

public class MSIMonitor implements Monitor{
    @Override
    public void createMonitor() {
        System.out.println("MSI Monitor") ;
    }
}
