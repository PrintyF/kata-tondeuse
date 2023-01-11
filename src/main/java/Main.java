import tondeuse.Mower;

import java.io.IOException;
import java.util.ArrayList;

import static tondeuse.file.parser.MowerFileParser.getMowersFromFile;

public class Main {
        public static void main(String[] args) throws IOException {
            if (args.length > 0) {
                ArrayList<Mower> mowers = getMowersFromFile(args[0]);
                for (Mower mower: mowers) {
                    displayMower(mower);
                }
            }
        }

    private static void displayMower(Mower mower) {
            System.out.println(mower.getCoordinates().getX() + " " + mower.getCoordinates().getY() + " " + mower.getDirection().getValue());
    }

}
