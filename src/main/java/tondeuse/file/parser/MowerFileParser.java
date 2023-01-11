package tondeuse.file.parser;

import tondeuse.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MowerFileParser {

    static List<String> readFile(String pathFileName) throws IOException {
        Path path = Paths.get(pathFileName);
        return Files.readAllLines(path);
    }

    public static ArrayList<Mower> getMowersFromFile(String pathFileName) throws IOException {

        ArrayList<Mower> mowers = new  ArrayList<>();
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
                ArrayList<Action> actions = new ArrayList<>();
                for (String action: splitLine[0].split("")) {
                    actions.add(Action.fromValue(action.charAt(0)));
                }
                mower.executeActions(actions);
                mowers.add(mower);
            }
        }
        return mowers;
    }

}
