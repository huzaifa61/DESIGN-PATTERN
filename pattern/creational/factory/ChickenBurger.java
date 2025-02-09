package creational.factory;

public class ChickenBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("chinken burger cooking");
    }
}
