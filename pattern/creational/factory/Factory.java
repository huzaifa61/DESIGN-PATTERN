package creational.factory;

public class Factory {

    public static void main(String args[]){
        Restaurant restaurant = new ChickenBurgerRestaurant();
        Burger burger= restaurant.orderburger();

    }

}
