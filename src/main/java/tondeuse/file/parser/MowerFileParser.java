package tondeuse.file.parser;

import tondeuse.Coordinates;
import tondeuse.MowerMap;
import tondeuse.Direction;
import tondeuse.Mower;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MowerFileParser {

    static List<String> readFile(String pathFileName) throws IOException {
        Path path = Paths.get(pathFileName);
        return Files.readAllLines(path);
    }

    public static String getMowersFromFile(String pathFileName) throws IOException {

        StringBuilder finalPositions = new StringBuilder();
        List<String> read = readFile(pathFileName);
        MowerMap mowerMap = null;
        Coordinates coordinates = null;
        Direction direction = null;

        for (int i = 0; i < read.size(); i++) {
            String[] splitLine = read.get(i).split(" ");
            if (i == 0) {
                mowerMap = new MowerMap(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]));
            }
            else if (i % 2 == 1) {
                coordinates = new Coordinates(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]));
                direction = Direction.getDirectionFromValue(splitLine[2]);
            }
            else {
                Mower mower = new Mower(coordinates, mowerMap);
                mower.setDirection(direction);
                mower.setActions(splitLine[0]);
                finalPositions.append(mower.getFinalPosition());
                if (i < read.size() - 1)
                    finalPositions.append("\n");
            }
        }
        return finalPositions.toString();
    }

}
