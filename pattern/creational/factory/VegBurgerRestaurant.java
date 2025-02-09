package creational.factory;

public class VegBurgerRestaurant extends  Restaurant{
    @Override
    public Burger createBurger() {
        return new VeggieBurger();
    }
}
