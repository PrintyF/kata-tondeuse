package tondeuse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MowerTest {

    Mower mower;

    @BeforeEach
    void settings() {
        mower = new Mower(new Coordinates(0 , 0), new MowerMap(5, 5));
    }

    @Nested
    class turn {
        @Nested
        class right {

            @BeforeEach
            void setting() {
                mower.setActions("D");
            }
            @Test
            void should_facing_east_when_north() {
                mower.setDirection(Direction.NORTH);
                assertEquals("0 0 E", mower.getFinalPosition());
            }
            @Test
            void should_facing_south_when_facing_east() {
                mower.setDirection(Direction.EAST);
                assertEquals("0 0 S", mower.getFinalPosition());
            }
            @Test
            void should_facing_west_when_south() {
                mower.setDirection(Direction.SOUTH);
                assertEquals("0 0 W", mower.getFinalPosition());
            }
        }

        @Nested
        class left {
            @BeforeEach
            void setting() {
                mower.setActions("G");
            }

            @Test
            void should_facing_west_when_north() {
                mower.setDirection(Direction.NORTH);
                assertEquals("0 0 W", mower.getFinalPosition());
            }
            @Test
            void should_facing_north_when_east() {
                mower.setDirection(Direction.EAST);
                assertEquals("0 0 N", mower.getFinalPosition());
            }
            @Test
            void should_facing_est_when_south() {
                mower.setDirection(Direction.SOUTH);
                assertEquals("0 0 E", mower.getFinalPosition());
            }
        }

    }

    @Nested
    class move {
        @BeforeEach
        void setting() {
            mower.setActions("A");
        }

        @Test
        public void should_move_one_east() {
            mower.setDirection(Direction.EAST);
            assertEquals("1 0 E", mower.getFinalPosition());
        }

        @Test
        public void should_move_one_south() {
            mower.setPosition(new Coordinates(0, 1));
            mower.setDirection(Direction.SOUTH);
            assertEquals("0 0 S", mower.getFinalPosition());
        }
        @Test
        public void should_not_move_because_of_out_of_bound_min() {
            mower.setDirection(Direction.SOUTH);
            assertEquals("0 0 S", mower.getFinalPosition());
        }
        @Test
        public void should_not_move_because_of_out_of_bound_max() {
            mower.setPosition(new Coordinates(5, 0));
            mower.setDirection(Direction.EAST);
            assertEquals("5 0 E", mower.getFinalPosition());
        }
    }

    @Test
    public void should_chain_actions() {
        mower.setPosition(new Coordinates(1, 1));
        mower.setActions("AGA");
        mower.setDirection(Direction.SOUTH);
        assertEquals("2 0 E", mower.getFinalPosition());
    }

}
