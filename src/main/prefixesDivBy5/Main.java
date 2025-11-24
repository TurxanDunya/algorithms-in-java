package main.prefixesDivBy5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        List<Boolean> result = solution.prefixesDivBy5(new int[]{0, 1, 1});
        System.out.println(result);
    }

    public static class Solution1 {
        public List<Boolean> prefixesDivBy5(int[] nums) {
            StringBuilder currentArrayAsString = new StringBuilder();

            Boolean[] result = new Boolean[nums.length];

            for (int i = 0; i < nums.length; i++) {
                currentArrayAsString.append(nums[i]);
                int value = convertToDecimal(currentArrayAsString.toString());
                if (value % 5 == 0) {
                    result[i] = Boolean.TRUE;
                } else {
                    result[i] = Boolean.FALSE;
                }
            }

            return Arrays.asList(result);
        }

        public int convertToDecimal(String binary) {
            char[] numAsCharArray = binary.toCharArray();
            int power = numAsCharArray.length - 1;

            int result = 0;
            for (char element : numAsCharArray) {
                int bit = element - '0';
                result += bit * (1 << power);
                power--;
            }
            return result;
        }
    }

    public static class Solution2 {
        public List<Boolean> prefixesDivBy5(int[] nums) {
            List<Boolean> result = new ArrayList<>(nums.length);
            int current = 0;

            for (int bit : nums) {
                current = (current * 2 + bit) % 5;
                result.add(current == 0);
            }
            return result;
        }
    }

}
