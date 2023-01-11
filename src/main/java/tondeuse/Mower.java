package tondeuse;

import util.VoidLambda;

import java.util.ArrayList;
import java.util.Map;

import static tondeuse.Action.*;

public class Mower {
    private Coordinates coordinates;

    private final MowerMap map;
    private Direction direction;

    public void setPosition(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Mower(Coordinates coordinates, MowerMap map) {
        this.coordinates = coordinates;
        this.map = map;
    }

    private void turn(Action action) {
        int offset = LEFT == action ? 3 : 1;
        direction = Direction.directions.get(
                (Direction.directions.indexOf(direction) + offset) % Direction.directions.size()
        );
    }
    private void moveForward() {
        Coordinates nextCoordinates = coordinates.getNextCoordinates(direction);
        if (!map.isOutOfBound(nextCoordinates))
            coordinates.moveTo(nextCoordinates);
    }


    public void executeActions(ArrayList<Action> actions) {
        for (Action action : actions) {
            executeAction(action);
        }
    }

    public void executeAction(Action action) {
        Map<Action, VoidLambda> moves = Map.of(
                LEFT, () -> turn(LEFT),
                RIGHT, () -> turn(RIGHT),
                FORWARD, this::moveForward);
        moves.get(action).run();
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
