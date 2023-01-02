package tondeuse;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TondeuseTest {

    private final Tondeuse tondeuse = new Tondeuse();

    @Before
    public void settings() {
        tondeuse.setPosX(0);
        tondeuse.setPosY(0);
        tondeuse.setLimitX(5);
        tondeuse.setLimitY(5);
    }

    @Test
    public void rightTurn() {
        tondeuse.setActions("D");
        tondeuse.setDirection(Direction.NORTH);
        assertThat(tondeuse.getFinalPosition(), is("0 0 E"));
        tondeuse.setDirection(Direction.EAST);
        assertThat(tondeuse.getFinalPosition(), is("0 0 S"));
        tondeuse.setDirection(Direction.SOUTH);
        assertThat(tondeuse.getFinalPosition(), is("0 0 W"));
    }
    @Test
    public void leftTurn() {
        tondeuse.setActions("G");
        tondeuse.setDirection(Direction.NORTH);
        assertThat(tondeuse.getFinalPosition(), is("0 0 W"));
        tondeuse.setDirection(Direction.EAST);
        assertThat(tondeuse.getFinalPosition(), is("0 0 N"));
        tondeuse.setDirection(Direction.SOUTH);
        assertThat(tondeuse.getFinalPosition(), is("0 0 E"));
    }

    @Test
    public void moveForward() {
        tondeuse.setActions("A");
        tondeuse.setDirection(Direction.EAST);
        assertThat(tondeuse.getFinalPosition(), is("1 0 E"));
        tondeuse.setPosX(0);
        tondeuse.setPosY(1);
        tondeuse.setDirection(Direction.SOUTH);
        assertThat(tondeuse.getFinalPosition(), is("0 0 S"));
    }
    @Test
    public void moveForwardOutOfBound() {
        tondeuse.setActions("A");
        tondeuse.setDirection(Direction.SOUTH);
        assertThat(tondeuse.getFinalPosition(), is("0 0 S"));
        tondeuse.setPosX(5);
        tondeuse.setDirection(Direction.EAST);
        assertThat(tondeuse.getFinalPosition(), is("5 0 E"));
    }

    @Test
    public void chainActions() {
        tondeuse.setPosX(1);
        tondeuse.setPosY(1);
        tondeuse.setActions("AGA");
        tondeuse.setDirection(Direction.SOUTH);
        assertThat(tondeuse.getFinalPosition(), is("2 0 E"));
    }

}
