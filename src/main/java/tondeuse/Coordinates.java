package tondeuse;

import util.VoidLambda;

import java.util.Map;

import static tondeuse.Direction.*;

public class Coordinates {
    private final Map<Direction, VoidLambda> moves = Map.of(
            NORTH, () -> this.y++,
            EAST, () -> this.x++,
            WEST, () -> this.x--,
            SOUTH, () -> this.y--);
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public void moveTo(Coordinates coordinates) {
        this.x = coordinates.x;
        this.y = coordinates.y;
    }

    public Coordinates getNextCoordinates(Direction direction) {
        Coordinates next = new Coordinates(x, y);
        next.moves.get(direction).run();
        return next;
    }
}
