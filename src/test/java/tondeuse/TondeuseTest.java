package tondeuse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TondeuseTest {

    Tondeuse tondeuse;

    @BeforeEach
    void settings() {
        tondeuse = new Tondeuse();
        tondeuse.setPosX(0);
        tondeuse.setPosY(0);
        tondeuse.setLimitX(5);
        tondeuse.setLimitY(5);
    }

    @Nested
    class turn {
        @Nested
        class right {

            @BeforeEach
            void setting() {
                tondeuse.setActions("D");
            }
            @Test
            void should_facing_east_when_north() {
                tondeuse.setDirection(Direction.NORTH);
                assertEquals(tondeuse.getFinalPosition(), "0 0 E");
            }
            @Test
            void should_facing_south_when_facing_east() {
                tondeuse.setDirection(Direction.EAST);
                assertEquals(tondeuse.getFinalPosition(), "0 0 S");
            }
            @Test
            void should_facing_west_when_south() {
                tondeuse.setDirection(Direction.SOUTH);
                assertEquals(tondeuse.getFinalPosition(), "0 0 W");
            }
        }

        @Nested
        class left {
            @BeforeEach
            void setting() {
                tondeuse.setActions("G");
            }

            @Test
            void should_facing_west_when_north() {
                tondeuse.setDirection(Direction.NORTH);
                assertEquals(tondeuse.getFinalPosition(), "0 0 W");
            }
            @Test
            void should_facing_north_when_east() {
                tondeuse.setDirection(Direction.EAST);
                assertEquals(tondeuse.getFinalPosition(), "0 0 N");
            }
            @Test
            void should_facing_est_when_south() {
                tondeuse.setDirection(Direction.SOUTH);
                assertEquals(tondeuse.getFinalPosition(), "0 0 E");
            }
        }

    }

    @Nested
    class move {
        @BeforeEach
        void setting() {
            tondeuse.setActions("A");
        }

        @Test
        public void should_move_one_east() {
            tondeuse.setDirection(Direction.EAST);
            assertEquals(tondeuse.getFinalPosition(), "1 0 E");
        }

        @Test
        public void should_move_one_south() {
            tondeuse.setPosX(0);
            tondeuse.setPosY(1);
            tondeuse.setDirection(Direction.SOUTH);
            assertEquals(tondeuse.getFinalPosition(), "0 0 S");
        }
        @Test
        public void should_not_move_because_of_out_of_bound_min() {
            tondeuse.setDirection(Direction.SOUTH);
            assertEquals(tondeuse.getFinalPosition(), "0 0 S");
        }
        @Test
        public void should_not_move_because_of_out_of_bound_max() {
            tondeuse.setPosX(5);
            tondeuse.setDirection(Direction.EAST);
            assertEquals(tondeuse.getFinalPosition(), "5 0 E");
        }
    }

    @Test
    public void should_chain_actions() {
        tondeuse.setPosX(1);
        tondeuse.setPosY(1);
        tondeuse.setActions("AGA");
        tondeuse.setDirection(Direction.SOUTH);
        assertEquals(tondeuse.getFinalPosition(), "2 0 E");
    }

}
