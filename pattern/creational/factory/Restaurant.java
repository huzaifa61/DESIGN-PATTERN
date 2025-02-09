package creational.factory;

public abstract class Restaurant {

    public Burger orderburger (){

        Burger burger = createBurger();
        burger.prepare();
        return  burger;

    }

   public abstract Burger createBurger();
}
