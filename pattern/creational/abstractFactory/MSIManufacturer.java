package creational.abstractFactory;

public class MSIManufacturer extends Manufacturer{
    @Override
    public GPU createGPU() {
        return new MSIGPU();
    }

    @Override
    public Monitor createMonitor() {
        return new MSIMonitor();
    }
}
