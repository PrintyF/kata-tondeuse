package tondeuse.it;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tondeuse.Coordinates;
import tondeuse.Direction;
import tondeuse.Mower;
import tondeuse.MowerMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tondeuse.Action.*;
import static tondeuse.Action.FORWARD;
import static tondeuse.Direction.*;

public class MowerActionsIT {
    Mower mower;
    MowerMap map;
    @BeforeEach
    void settings() {
        mower = new Mower(new Coordinates(0 , 0), NORTH);
        map = new MowerMap(5, 5);
    }

    @Nested
    class turn {
        @Nested
        class right {

            @Test
            void should_facing_east_when_north() {
                mower.setDirection(NORTH);
                mower.executeAction(RIGHT, map);
                assertEquals(mower.getDirection(), EAST);
            }
            @Test
            void should_facing_south_when_facing_east() {
                mower.setDirection(EAST);
                mower.executeAction(RIGHT, map);
                assertEquals(mower.getDirection(), SOUTH);
            }
            @Test
            void should_facing_west_when_south() {
                mower.setDirection(Direction.SOUTH);
                mower.executeAction(RIGHT, map);
                assertEquals(mower.getDirection(), WEST);
            }
        }

        @Nested
        class left {
            @Test
            void should_facing_west_when_north() {
                mower.setDirection(NORTH);
                mower.executeAction(LEFT, map);
                assertEquals(mower.getDirection(), WEST);
            }
            @Test
            void should_facing_north_when_east() {
                mower.setDirection(Direction.EAST);
                mower.executeAction(LEFT, map);
                assertEquals(mower.getDirection(), NORTH);
            }
            @Test
            void should_facing_est_when_south() {
                mower.setDirection(Direction.SOUTH);
                mower.executeAction(LEFT, map);
                assertEquals(mower.getDirection(), EAST);
            }
        }

    }

    @Nested
    class move {
        @Test
        public void should_move_one_east() {
            Coordinates expectedCoordinates = new Coordinates(2, 1);
            mower.setDirection(EAST);
            mower.setPosition(new Coordinates(1, 1));
            mower.executeAction(FORWARD, map);
            assertEquals(mower.getCoordinates(), expectedCoordinates);
        }

        @Test
        public void should_move_one_south() {
            Coordinates expectedCoordinates = new Coordinates(1, 0);
            mower.setDirection(SOUTH);
            mower.setPosition(new Coordinates(1, 1));
            mower.executeAction(FORWARD, map);
            assertEquals(mower.getCoordinates(), expectedCoordinates);
        }
        @Test
        public void should_not_move_because_of_out_of_bound_min() {
            Coordinates expectedCoordinates = new Coordinates(0, 0);
            mower.setDirection(SOUTH);
            mower.setPosition(new Coordinates(0, 0));
            mower.executeAction(FORWARD, map);
            assertEquals(mower.getCoordinates(), expectedCoordinates);
        }
        @Test
        public void should_not_move_because_of_out_of_bound_max() {
            Coordinates expectedCoordinates = new Coordinates(5, 5);
            mower.setDirection(NORTH);
            mower.setPosition(new Coordinates(5, 5));
            mower.executeAction(FORWARD, map);
            assertEquals(mower.getCoordinates(), expectedCoordinates);
        }
    }
}
