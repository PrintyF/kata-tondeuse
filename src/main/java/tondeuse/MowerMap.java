package tondeuse;

import java.util.Objects;

public class MowerMap {
    private final int x;
    private final int y;

    public MowerMap(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isOutOfBound(Coordinates coordinates) {
        return  coordinates.getX() > x ||
                coordinates.getX() < 0 ||
                coordinates.getY() > y ||
                coordinates.getY() < 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MowerMap other) {
            return other.x == x && other.y == y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }
}
