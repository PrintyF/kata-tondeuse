import java.util.Arrays;
import java.util.List;

public enum Direction {
    NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

    private final String value;
    public static final List<Direction> directions =
            Arrays.asList(NORTH, EAST, SOUTH, WEST);

    Direction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}