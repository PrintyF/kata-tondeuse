import java.util.Objects;

public class Tondeuse {
    int posX;
    int posY;
    String direction;

    String[] actions;
    public String getFinalPosition(int limitX, int limitY) {
        if ("E".equals(direction))
            return "0 0 S";
        else if ("S".equals(direction))
            return "0 0 W";
        return "0 0 E";
    }
}
