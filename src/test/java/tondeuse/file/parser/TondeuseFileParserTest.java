package tondeuse.file.parser;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TondeuseFileParserTest {
    private final TondeuseFileParser fileParser = new TondeuseFileParser();

    @Test
    public void getTondeusesFromFile() throws IOException {
        String results = fileParser.getTondeusesByFile("/Users/codeworks/IdeaProjects/kata-tondeuse/src/test/ressources/tondeusesInput");

        assertThat(results, is("1 3 N\n" + "5 1 E"));
    }

}
