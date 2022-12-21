import java.util.Map;

public class Tondeuse {
    int posX;
    int posY;

    int limitX;
    int limitY;
    Direction direction;

    String actions;

    private final Map<String, Runnable> move = Map.of(
            "N", () -> {
                if (limitY > posY) posY++;
            },
            "E", () -> {
                if (limitX > posX) posX++;
            },
            "W", () ->  {
                if (posX > 0) posX--;
            },
            "S", () -> {
                if (posY > 0) posY--;
            });

    void turn(String action) {
        int offset = "G".equals(action) ? 3 : 1;
        direction = Direction.directions.get(
                (Direction.directions.indexOf(direction) + offset) % 4
        );
    }

    void moveForward() {
       move.get(direction.getValue()).run();
    }


    public String getFinalPosition() {
        for (String action: actions.split("")) {
            if ("A".equals(action))
                this.moveForward();
            else
                this.turn(action);
        }
        return posX + " " + posY  + " " + direction.getValue();
    }
}
