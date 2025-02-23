package elevator;

public class Floor {
    int floor;
    ExternalDispatcher externalDispatcher;

    public Floor(int floor) {
        this.floor = floor;
        this.externalDispatcher = new ExternalDispatcher();
    }

    public void pressButton(Direction direction) {
        externalDispatcher.submitExternalRequest(floor,direction);
    }
}
