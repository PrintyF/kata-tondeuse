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
        tondeuse.direction = "N";
        assertThat(tondeuse.getFinalPosition(5, 5), is("0 0 E"));
    }
}
