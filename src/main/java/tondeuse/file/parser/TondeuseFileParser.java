package tondeuse.file.parser;

import tondeuse.Direction;
import tondeuse.Tondeuse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TondeuseFileParser {

    static List<String> readFile(String pathFileName) throws IOException {
        Path path = Paths.get(pathFileName);
        return Files.readAllLines(path);
    }

    public static String getTondeusesByFile(String pathFileName) throws IOException {

        StringBuilder finalPositions = new StringBuilder();
        Tondeuse tondeuse = new Tondeuse();
        List<String> read = readFile(pathFileName);

        for (int i = 0; i < read.size(); i++) {
            String[] splitLine = read.get(i).split(" ");
            if (i == 0) {
                tondeuse.setLimitX(Integer.parseInt(splitLine[0]));
                tondeuse.setLimitY(Integer.parseInt(splitLine[1]));
            }
            else if (i % 2 == 1) {
                tondeuse.setPosX(Integer.parseInt(splitLine[0]));
                tondeuse.setPosY(Integer.parseInt(splitLine[1]));
                tondeuse.setDirection(Direction.getDirectionFromValue(splitLine[2]));
            }
            else {
                tondeuse.setActions(splitLine[0]);
                finalPositions.append(tondeuse.getFinalPosition());
                if (i < read.size() - 1)
                    finalPositions.append("\n");
            }
        }
        return finalPositions.toString();
    }

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            System.out.println(getTondeusesByFile(args[0]));
        }
    }


}
