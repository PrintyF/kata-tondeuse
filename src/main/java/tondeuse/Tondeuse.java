package tondeuse;

import util.VoidLambda;

import java.util.Map;
import java.util.function.Consumer;

public class Tondeuse {
    int posX;
    int posY;

    int limitX;

    int limitY;
    Direction direction;

    String actions;

    private final Map<String, VoidLambda> move = Map.of(
            "N", () -> {
                if (limitY > posY) posY++;
            },
            "E", () -> {
                if (limitX > posX) posX++;
            },
            "W", () -> {
                if (posX > 0) posX--;
            },
            "S", () -> {
                if (posY > 0) posY--;
            });

    void turn(String action) {
        int offset = "G".equals(action) ? 3 : 1;
        direction = Direction.directions.get(
                (Direction.directions.indexOf(direction) + offset) % Direction.directions.size()
        );
    }
    void moveForward() {
        move.get(direction.getValue()).run();
    }


    public String getFinalPosition() {
        for (String action : actions.split("")) {
            if ("A".equals(action))
                this.moveForward();
            else
                this.turn(action);
        }
        return posX + " " + posY + " " + direction.getValue();
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getLimitX() {
        return limitX;
    }

    public void setLimitX(int limitX) {
        this.limitX = limitX;
    }

    public int getLimitY() {
        return limitY;
    }

    public void setLimitY(int limitY) {
        this.limitY = limitY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }
}
