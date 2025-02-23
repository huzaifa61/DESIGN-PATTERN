package LLDShoppingCart;

abstract class DiscountDecorator {
    protected Cart cart;

    public DiscountDecorator(Cart cart) {
        this.cart = cart;
    }

    public abstract double getDiscountedTotal();
}

