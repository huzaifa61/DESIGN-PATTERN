package creational.abstractFactory;

public class ASUSManufacturer extends Manufacturer{
    @Override
    public GPU createGPU() {
        return new ASUSGPU();
    }

    @Override
    public Monitor createMonitor() {
        return new ASUSMonitor();
    }
}
