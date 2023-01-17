package tondeuse.file.parser;

import tondeuse.Action;
import tondeuse.Coordinates;
import tondeuse.Direction;

import java.util.ArrayList;
import java.util.Objects;

public class MowerSettings {
    public Coordinates coordinates;
    public Direction direction;
    public ArrayList<Action> actions;

    public MowerSettings(Coordinates coordinates, Direction direction, ArrayList<Action> actions) {
        this.coordinates = coordinates;
        this.direction = direction;
        this.actions = actions;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MowerSettings other) {
            return other.coordinates.equals(coordinates) && other.direction.equals(direction) && other.actions.equals(actions);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, direction, actions);
    }

}
