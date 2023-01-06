package tondeuse.file.parser;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MowerFileParserTest {
    @Test
    public void getMowersFromFile() throws IOException {
        String path = "src/test/resources/tondeusesInput";
        File file = new File(path);

        String absolutePath = file.getAbsolutePath();
        String results = MowerFileParser.getMowersFromFile(absolutePath);

        assertEquals(results, "1 3 N\n" + "5 1 E");
    }

}
