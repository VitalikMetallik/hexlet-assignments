package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        try {
            MaxThread maxThread = new MaxThread(numbers);
            MinThread minThread = new MinThread(numbers);
            maxThread.start();
            LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " started");
            minThread.start();
            LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " started");
            maxThread.join();
            minThread.join();
            Map<String, Integer> result = new HashMap<>();
            result.put("max", maxThread.getMaxNumber());
            result.put("min", minThread.getMinNumber());
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    // END
}
