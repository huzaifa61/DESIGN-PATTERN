package LLDRestaurant;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AssignmentService {

    private void validateAssignment(Assignment assignment) {

    }

    private void createAssignment(Assignment assignment) {
        validateAssignment(assignment);
        assignment.setCreatedAt(LocalDateTime.now());
        assignment.setUpdatedAt(LocalDateTime.now());

    }


}
