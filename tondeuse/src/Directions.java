import java.util.Arrays;
import java.util.List;

public enum Directions {
    NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

    public final String value;

    private static final List<Directions> directions =
            Arrays.asList(NORTH, EAST, SOUTH, WEST); // to not depend on
    Directions(String value) {
        this.value = value;
    }
    Directions turnRight() {
        return directions.get(directions.indexOf(this) + 1 % 4);
    }
    Directions turnLeft() {
        return directions.get((directions.indexOf(this) + 3) % 4);
    }
}
