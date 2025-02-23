package LLDShoppingCart;

class PercentageDiscount extends DiscountDecorator {
    private double discountPercentage;

    public PercentageDiscount(Cart cart, double discountPercentage) {
        super(cart);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getDiscountedTotal() {
        return cart.calculateTotal() * (1 - discountPercentage / 100);
    }
}
