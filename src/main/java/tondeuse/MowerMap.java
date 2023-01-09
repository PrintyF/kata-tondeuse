package tondeuse;

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
}
