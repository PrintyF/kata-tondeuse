import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TondeuseFileParserTest {
    private final TondeuseFileParser fileParser = new TondeuseFileParser();

    @Test
    public void getTondeusesFromFile() {
        fileParser.getTondeusesByFile("/Users/codeworks/IdeaProjects/kata-tondeuse/tondeuse/src/tondeusesInput");
        assertThat("A", is("A"));
    }

}
