import tondeuse.Mower;
import tondeuse.file.parser.InputSettings;
import tondeuse.file.parser.MowerSettings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static tondeuse.file.parser.MowerFileParser.parseMowerFile;

public class  Main {
        public static void main(String[] args) throws IOException {
            if (args.length > 0) {
                InputSettings inputSettings = parseMowerFile(args[0]);
                List<Mower> mowers = getMowersFromMowersSettings(inputSettings);
                executeMowersActions(inputSettings, mowers);
                for (Mower mower: mowers) {
                    System.out.println(mower.toString());
                }
            }
        }

        private static List<Mower> getMowersFromMowersSettings(InputSettings inputsSettings) {
            List<Mower> mowers = new ArrayList<>();
            for (MowerSettings mowerSettings: inputsSettings.mowersSettings) {
                mowers.add(new Mower(mowerSettings.coordinates, mowerSettings.direction));
            }
            return mowers;
        }

        private static void executeMowersActions(InputSettings inputSettings, List<Mower> mowers) {
            for (int i = 0; i < mowers.size(); i++) {
                mowers.get(i).executeActions(inputSettings.mowersSettings.get(i).actions, inputSettings.map);
            }
        }

}
