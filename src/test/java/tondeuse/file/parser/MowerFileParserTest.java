package tondeuse.file.parser;

import org.junit.jupiter.api.Test;
import tondeuse.Mower;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MowerFileParserTest {
    @Test
    public void getMowersFromFile() throws IOException {
        String path = "src/test/resources/tondeusesInput";
        File file = new File(path);

        String absolutePath = file.getAbsolutePath();
        ArrayList<Mower> mowers = MowerFileParser.getMowersFromFile(absolutePath);
        assertEquals(mowers.get(0).getCoordinates().getX(), 1);
    }

}
