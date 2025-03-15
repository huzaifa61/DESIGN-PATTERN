package LLDRestaurant;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Assignment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Waiter waiter;

    @ManyToOne
    private RestaurantApp restaurant;

    @ManyToOne
    private Shift shift;

    private String status; // Active, Completed, Canceled
    private boolean isActive = true;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
