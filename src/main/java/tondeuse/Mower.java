package tondeuse;

public class Mower {
    private Coordinates coordinates;

    private final MowerMap map;

    private Direction direction;

    private String actions;


    public void setPosition(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Mower(Coordinates coordinates, MowerMap map) {
        this.coordinates = coordinates;
        this.map = map;
    }

    private void turn(String action) {
        int offset = "G".equals(action) ? 3 : 1;
        direction = Direction.directions.get(
                (Direction.directions.indexOf(direction) + offset) % Direction.directions.size()
        );
    }
    private void moveForward() {
        Coordinates nextCoordinates = coordinates.getNextCoordinates(direction.getValue());
        if (!map.isOutOfBound(nextCoordinates))
            coordinates.moveTo(nextCoordinates);
    }


    public String getFinalPosition() {
        for (String action : actions.split("")) {
            if ("A".equals(action))
                this.moveForward();
            else
                this.turn(action);
        }
        return coordinates.getX() + " " + coordinates.getY() + " " + direction.getValue();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

}
