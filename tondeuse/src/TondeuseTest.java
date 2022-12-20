import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TondeuseTest {

    private final Tondeuse tondeuse = new Tondeuse();

    @Test
    public void rightTurn() {
        tondeuse.posX = 0;
        tondeuse.posY = 0;
        tondeuse.actions = new String[]{"D"};
        tondeuse.direction = Direction.NORTH;
        assertThat(tondeuse.getFinalPosition(5, 5), is("0 0 E"));
        tondeuse.direction = Direction.EAST;
        assertThat(tondeuse.getFinalPosition(5, 5), is("0 0 S"));
        tondeuse.direction = Direction.SOUTH;
        assertThat(tondeuse.getFinalPosition(5, 5), is("0 0 W"));
    }
    @Test
    public void leftTurn() {
        tondeuse.posX = 0;
        tondeuse.posY = 0;
        tondeuse.actions = new String[]{"G"};
        tondeuse.direction = Direction.NORTH;
        assertThat(tondeuse.getFinalPosition(5, 5), is("0 0 W"));
        tondeuse.direction = Direction.EAST;
        assertThat(tondeuse.getFinalPosition(5, 5), is("0 0 N"));
        tondeuse.direction = Direction.SOUTH;
        assertThat(tondeuse.getFinalPosition(5, 5), is("0 0 E"));
    }

    @Test
    public void moveForward() {
        tondeuse.posX = 0;
        tondeuse.posY = 0;
        tondeuse.actions = new String[]{"A"};
        tondeuse.direction = Direction.EAST;
        assertThat(tondeuse.getFinalPosition(5, 5), is("1 0 E"));
        tondeuse.posX = 0;
        tondeuse.posY = 0;
        tondeuse.direction = Direction.SOUTH;
        assertThat(tondeuse.getFinalPosition(5, 5), is("0 1 S"));
    }
    @Test
    public void moveForwardOutOfBound() {
        tondeuse.posX = 0;
        tondeuse.posY = 0;
        tondeuse.actions = new String[]{"A"};
        tondeuse.direction = Direction.NORTH;
        assertThat(tondeuse.getFinalPosition(5, 5), is("0 0 N"));
        tondeuse.posX = 5;
        tondeuse.direction = Direction.EAST;
        assertThat(tondeuse.getFinalPosition(5, 5), is("5 0 E"));
    }

}
