package LLDShoppingCart;

import lombok.Getter;

public class User {
    @Getter
    private int userId;
    @Getter
    private String name;
    private String email;

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }


}
