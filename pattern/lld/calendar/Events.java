package calendar;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class Events {
    private List<User> attendies;
    public String location;
    public String title;
    String time;
    String description;
    String eventId;



}