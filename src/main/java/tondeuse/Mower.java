package tondeuse;

import util.VoidLambda;

import java.util.Map;

public class Mower {
    private Coordinates coordinates;

    private MowerMap map;

    private Direction direction;

    private String actions;


    private final Map<String, VoidLambda> move = Map.of(
            "N", () -> {
                if (map.getLimitY() > coordinates.getY()) coordinates.moveNorth();
            },
            "E", () -> {
                if (map.getLimitX() > coordinates.getX()) coordinates.moveEast();
            },
            "W", () -> {
                if (coordinates.getX() > 0) coordinates.moveWest();
            },
            "S", () -> {
                if (coordinates.getY() > 0) coordinates.moveSouth();
            });

    public void setPosition(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Mower(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    private void turn(String action) {
        int offset = "G".equals(action) ? 3 : 1;
        direction = Direction.directions.get(
                (Direction.directions.indexOf(direction) + offset) % Direction.directions.size()
        );
    }
    private void moveForward() {
        move.get(direction.getValue()).run();
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

    public void setMap(MowerMap map) {
        this.map = map;
    }
}
