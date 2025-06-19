package main.plusone;

import java.util.Arrays;

public class MyAndBestSolution {
    public int[] plusOne(int[] digits) {
        int lastIndexCursor = digits.length - 1;
        while (true) {
            if (lastIndexCursor == 0 && digits[lastIndexCursor] == 9) {
                digits[0] = 1;
                return Arrays.copyOf(digits, digits.length + 1);
            }

            int lastDigit = digits[lastIndexCursor];
            if (lastDigit <= 8) {
                digits[lastIndexCursor]++;
                return digits;
            } else {
                digits[lastIndexCursor] = 0;
            }

            lastIndexCursor--;
        }
    }
}
