package tondeuse;

public class MowerMap {
    private final int x;
    private final int y;

    public MowerMap(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getLimitY() {
        return this.y;
    }

    public int getLimitX() {
        return this.x;
    }
}
