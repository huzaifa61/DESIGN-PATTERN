package creational.abstractFactory;

public class MSIGPU implements GPU{
    @Override
    public void createGPU() {
        System.out.println("MSI GPU");
    }
}
