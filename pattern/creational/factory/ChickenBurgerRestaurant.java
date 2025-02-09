package creational.factory;


public class ChickenBurgerRestaurant extends  Restaurant{
    @Override
    public Burger createBurger() {
        return new ChickenBurger();
    }
}
