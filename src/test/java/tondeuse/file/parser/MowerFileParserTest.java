package tondeuse.file.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tondeuse.Action;
import tondeuse.Coordinates;
import tondeuse.MowerMap;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tondeuse.Action.*;
import static tondeuse.Direction.EAST;
import static tondeuse.Direction.NORTH;

public class MowerFileParserTest {

    InputSettings expectedValues = new InputSettings();

    @BeforeEach
    public void settings() {
        expectedValues.map = new MowerMap(5, 5);
        expectedValues.mowersSettings = new ArrayList<>();
        ArrayList<Action> actions = new ArrayList<>(List.of(LEFT, FORWARD, LEFT, FORWARD, LEFT, FORWARD, LEFT, FORWARD, FORWARD));
        MowerSettings mowerSettings = new MowerSettings(new Coordinates(1,2), NORTH, actions);
        expectedValues.mowersSettings.add(mowerSettings);
        actions = new ArrayList<>(List.of(FORWARD, FORWARD, RIGHT, FORWARD, FORWARD, RIGHT, FORWARD, RIGHT, RIGHT, FORWARD));
        mowerSettings = new MowerSettings(new Coordinates(3,3), EAST, actions);
        expectedValues.mowersSettings.add(mowerSettings);
    }
    @Test
    public void should_get_inputs_from_file() throws IOException {
        String path = "src/test/resources/tondeusesInput";
        File file = new File(path);

        String absolutePath = file.getAbsolutePath();
        InputSettings inputSettings = MowerFileParser.parseMowerFile(absolutePath);
        assertEquals(inputSettings, expectedValues);
    }

}
