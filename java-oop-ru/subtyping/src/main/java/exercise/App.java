package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        if (storage == null) {
        } else {
            for (var entry : storage.toMap().entrySet()) {
                storage.unset(entry.getKey());
                storage.set(entry.getValue(), entry.getKey());
            }
        }
    }
}
// END
