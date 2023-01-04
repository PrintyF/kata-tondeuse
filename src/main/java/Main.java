import java.io.IOException;

import static tondeuse.file.parser.TondeuseFileParser.getTondeusesByFile;

public class Main {
        public static void main(String[] args) throws IOException {
            if (args.length > 0) {
                System.out.println(getTondeusesByFile(args[0]));
            }
        }

}
