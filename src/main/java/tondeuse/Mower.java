package tondeuse;

import util.VoidLambda;

import java.util.ArrayList;
import java.util.Map;

import static tondeuse.Action.*;

public class Mower {
    private Coordinates coordinates;

    private Direction direction;

    public void setPosition(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public Mower(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    private void turn(Action action) {
        int offset = LEFT == action ? 3 : 1;
        direction = Direction.directions.get(
                (Direction.directions.indexOf(direction) + offset) % Direction.directions.size()
        );
    }
    private void moveForward(MowerMap map) {
        Coordinates nextCoordinates = coordinates.getNextCoordinates(direction);
        if (!map.isOutOfBound(nextCoordinates))
            coordinates.moveTo(nextCoordinates);
    }


    public void executeActions(ArrayList<Action> actions,  MowerMap map) {
        for (Action action : actions) {
            executeAction(action, map);
        }
    }

    public void executeAction(Action action,  MowerMap map) {
        Map<Action, VoidLambda> moves = Map.of(
                LEFT,       () -> turn(LEFT),
                RIGHT,      () -> turn(RIGHT),
                FORWARD,    () -> moveForward(map));
        moves.get(action).run();
    }

    @Override
    public String toString() {
        return coordinates.toString() +
                " " + direction.getValue();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
