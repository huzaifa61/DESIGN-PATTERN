package LLDRestaurant;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Waiter {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String ManagerName;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
