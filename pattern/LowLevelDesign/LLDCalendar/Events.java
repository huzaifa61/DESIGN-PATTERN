package LLDCalendar;
import lombok.AllArgsConstructor;
import lombok.Data;

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