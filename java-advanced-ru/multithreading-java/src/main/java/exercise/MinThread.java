package exercise;

import java.util.Arrays;
// BEGIN
public class MinThread extends Thread {
    private final int[] numbers;
    private int minNumber;

    public int getMinNumber() {
        return minNumber;
    }

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        this.minNumber = Arrays.stream(numbers).min().getAsInt();
    }
}
// END
