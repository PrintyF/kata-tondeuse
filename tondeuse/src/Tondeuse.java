public class Tondeuse {
    int posX;
    int posY;
    Directions direction;

    String[] actions;
    public String getFinalPosition(int limitX, int limitY) {
        if ("G".equals(actions[0]))
            return "0 0 " + direction.turnLeft().value;
        else if ("D".equals(actions[0]))
            return "0 0 " + direction.turnRight().value;
        else
            return "1 0 " + direction.value;
    }
}
