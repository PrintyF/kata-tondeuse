public class Tondeuse {
    int posX;
    int posY;
    Directions direction;

    String[] actions;
    public String getFinalPosition(int limitX, int limitY) {
        String response  = "0 0 " + direction.turnRight().value;
        return response;
    }
}
