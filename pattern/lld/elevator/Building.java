package elevator;

import java.util.List;

public class Building {
    List<Floor> floorList;

    Building(List<Floor> floors){
        this.floorList = floors;
    }

    public void addFloors(Floor newFloor){
        floorList.add(newFloor);
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void removeFloor(){
        floorList.remove(floorList.size()-1);
    }
}
