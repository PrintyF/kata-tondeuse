package tondeuse.coordinates.ut;

import org.junit.jupiter.api.Test;
import tondeuse.Coordinates;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    public void should_have_same_hash_when_equal() {
        Coordinates key1 = new Coordinates(0, 0);
        Coordinates key2 = new Coordinates(0, 0);
        assertEquals(key1.hashCode(), key2.hashCode());
    }
}
