import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TondeuseFileParser {

    void getTondeusesByFile(String pathFileName) {
        Path path = Paths.get(pathFileName);
        try {
            Tondeuse tondeuse = new Tondeuse();
            List<String> read = Files.readAllLines(path);

            for (int i = 0; i < read.size(); i++) {
                String[] splitLine = read.get(i).split(" ");
                if (i == 0) {
                    tondeuse.limitX = Integer.parseInt(splitLine[0]);
                    tondeuse.limitY = Integer.parseInt(splitLine[1]);
                }
                else if (i % 2 == 1) {
                    tondeuse.posX = Integer.parseInt(splitLine[0]);
                    tondeuse.posY = Integer.parseInt(splitLine[1]);
                    tondeuse.direction = Direction.getDirectionFromValue(splitLine[2]);
                }
                else {
                    tondeuse.actions = splitLine[0];
                    System.out.println(tondeuse.getFinalPosition());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
