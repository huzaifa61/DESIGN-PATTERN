package LLDRestaurant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assignments")
public class RestaurantController {

    @GetMapping("/{id}")
    public ResponseEntity<String> assignWaiters(@RequestBody Assignment assignment) {
        return ResponseEntity.ok("Waiter Assigned");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignment(@PathVariable Long id) {
        return ResponseEntity.ok(new Assignment());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> assignRestaurant(@PathVariable Long id) {
        return ResponseEntity.ok("Assignment Assigned");
    }

}
