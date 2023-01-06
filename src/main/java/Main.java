import java.io.IOException;

import static tondeuse.file.parser.MowerFileParser.getMowersFromFile;

public class Main {
        public static void main(String[] args) throws IOException {
            if (args.length > 0) {
                System.out.println(getMowersFromFile(args[0]));
            }
        }

}
