package exercise;

import java.util.Arrays;
// BEGIN
public class MaxThread extends Thread {
    private final int[] numbers;
    private int maxNumber;

    public int getMaxNumber() {
        return maxNumber;
    }

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        maxNumber = Arrays.stream(numbers).max().getAsInt();
    }
}
// END
