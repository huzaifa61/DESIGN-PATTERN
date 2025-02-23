package LLDShoppingCart;

import java.util.HashMap;
import java.util.Map;

class CartManager {
    private static CartManager instance;
    private Map<Integer, Cart> userCarts = new HashMap<>();

    private CartManager() {}

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public Cart getCart(int userId) {
        return userCarts.computeIfAbsent(userId, k -> new Cart());
    }
}
