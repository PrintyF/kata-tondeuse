package tondeuse.file.parser;

import tondeuse.*;

import java.util.List;
import java.util.Objects;

public class InputSettings {
    public MowerMap map;
    public List<MowerSettings> mowersSettings;

    @Override
    public int hashCode() {
        return Objects.hash(map, mowersSettings);
    }

    public boolean equals(Object obj) {
        if (obj instanceof InputSettings other) {
            return other.map.equals(map) && other.mowersSettings.equals(mowersSettings);
        }
        return false;
    }
}
