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

    public static InputSettings parseMowerFile(String pathFileName) throws IOException {

        List<String> read = readFile(pathFileName);
        InputSettings inputSettings = new InputSettings();
        inputSettings.mowersSettings = new ArrayList<>();

        Coordinates coordinates = null;
        Direction direction = null;
        ArrayList<Action> actions;

        for (int i = 0; i < read.size(); i++) {
            String[] splitLine = read.get(i).split(" ");

            if (i == 0) {
                inputSettings.map = new MowerMap(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]));
            }
            else if (i % 2 == 1) {
                coordinates = new Coordinates(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]));
                direction = Direction.getDirectionFromValue(splitLine[2]);
            }
            else {
                actions = new ArrayList<>();
                for (String action: splitLine[0].split("")) {
                    actions.add(Action.fromValue(action.charAt(0)));
                }
                MowerSettings mowerSettings = new MowerSettings(coordinates, direction, actions);
                inputSettings.mowersSettings.add(mowerSettings);
            }
        }
        return inputSettings;
    }

}
