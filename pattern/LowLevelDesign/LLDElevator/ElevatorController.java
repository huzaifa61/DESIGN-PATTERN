package LLDElevator;

import java.util.PriorityQueue;

public class ElevatorController {
    ElevatorCar elevatorCar;
    PriorityQueue<Integer> upMinQ;
    PriorityQueue<Integer> downMinQ;
    ElevatorController(ElevatorCar elevatorController) {
        this.elevatorCar = elevatorController;
        upMinQ = new PriorityQueue<>();
        downMinQ = new PriorityQueue<>((a,b)->b-a);
    }

    public void submitExternalRequest(int floor,Direction direction) {
        if(direction == Direction.UP) {
            downMinQ.add(floor);
        }else if(direction == Direction.DOWN) {
            upMinQ.add(floor);
        }

    }

    public void submitInternalRequest(int request) {

    }

    public void controlElevator(){
        while(true) {

            if(elevatorCar.elevatorDirection == Direction.UP){


            }
        }
    }


    public void submitInternalRequest(int floor,Direction direction){

    }
}
