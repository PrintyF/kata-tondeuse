package tondeuse;

import java.util.List;

public enum Direction {
    NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

    private final String value;
    public static final List<Direction> directions =
            List.of(NORTH, EAST, SOUTH, WEST);

    Direction(String value) {
        this.value = value;
    }

    public Character getValue() {
        return value.charAt(0);
    }

    public static Direction getDirectionFromValue(String value) {
        for (Direction direction: directions) {
            if (direction.value.equals(value))
                return direction;
        }
        return null;
    }

}