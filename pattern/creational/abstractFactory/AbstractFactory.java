package creational.abstractFactory;


public class AbstractFactory {
    public static void main(String[] args) {
        Manufacturer manufacturer = new MSIManufacturer();
        GPU gpu = manufacturer.createGPU();
        Monitor monitor = manufacturer.createMonitor();
        gpu.createGPU();
        monitor.createMonitor();
    }
}
