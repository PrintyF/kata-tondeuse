import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TondeuseTest {

    private final Tondeuse tondeuse = new Tondeuse();

    @Before
    public void settings() {
        tondeuse.posX = 0;
        tondeuse.posY = 0;
        tondeuse.limitX = 5;
        tondeuse.limitY = 5;
    }

    @Test
    public void rightTurn() {
        tondeuse.actions = "D";
        tondeuse.direction = Direction.NORTH;
        assertThat(tondeuse.getFinalPosition(), is("0 0 E"));
        tondeuse.direction = Direction.EAST;
        assertThat(tondeuse.getFinalPosition(), is("0 0 S"));
        tondeuse.direction = Direction.SOUTH;
        assertThat(tondeuse.getFinalPosition(), is("0 0 W"));
    }
    @Test
    public void leftTurn() {
        tondeuse.actions = "G";
        tondeuse.direction = Direction.NORTH;
        assertThat(tondeuse.getFinalPosition(), is("0 0 W"));
        tondeuse.direction = Direction.EAST;
        assertThat(tondeuse.getFinalPosition(), is("0 0 N"));
        tondeuse.direction = Direction.SOUTH;
        assertThat(tondeuse.getFinalPosition(), is("0 0 E"));
    }

    @Test
    public void moveForward() {
        tondeuse.actions = "A";
        tondeuse.direction = Direction.EAST;
        assertThat(tondeuse.getFinalPosition(), is("1 0 E"));
        tondeuse.posX = 0;
        tondeuse.posY = 1;
        tondeuse.direction = Direction.SOUTH;
        assertThat(tondeuse.getFinalPosition(), is("0 0 S"));
    }
    @Test
    public void moveForwardOutOfBound() {
        tondeuse.actions = "A";
        tondeuse.direction = Direction.SOUTH;
        assertThat(tondeuse.getFinalPosition(), is("0 0 S"));
        tondeuse.posX = 5;
        tondeuse.direction = Direction.EAST;
        assertThat(tondeuse.getFinalPosition(), is("5 0 E"));
    }

    @Test
    public void chainActions() {
        tondeuse.posX = 1;
        tondeuse.posY = 1;
        tondeuse.actions = "AGA";
        tondeuse.direction = Direction.SOUTH;
        assertThat(tondeuse.getFinalPosition(), is("2 0 E"));

    }


}
