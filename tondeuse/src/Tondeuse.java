import java.util.Map;
import java.util.function.Consumer;
import org.testng.internal.collections.Pair;

public class Tondeuse {
    int posX;
    int posY;
    Direction direction;

    String[] actions;

    private final Map<String, Consumer<Pair<Integer, Integer>>> move = Map.of(
            "S", (limit) -> {
                if (limit.second() > posY + 1) posY++;
            },
            "E", (limit) -> {
                if (limit.first() > posX + 1) posX++;
            },
            "W", (limit) ->  {
                if (posX > 0) posX--;
            },
            "N", (limit) -> {
                if (posY > 0) posY--;
            });

    void turnRight() {
        direction = Direction.directions.get((Direction.directions.indexOf(direction) + 1) % 4);
    }
    void turnLeft() {
        direction = Direction.directions.get((Direction.directions.indexOf(direction) + 3) % 4);
    }

    void moveForward(Pair<Integer, Integer> limits) {
       move.get(direction.getValue()).accept(limits);
    }


    public String getFinalPosition(int limitX, int limitY) {
        Pair<Integer, Integer> limits = new Pair<>(limitX, limitY);
        if ("G".equals(actions[0]))
            this.turnLeft();
        else if ("D".equals(actions[0]))
            this.turnRight();
        else
            this.moveForward(limits);
        return posX + " " + posY  + " " + direction.getValue();
    }
}
