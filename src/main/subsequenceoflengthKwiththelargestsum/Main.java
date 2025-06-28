package main.subsequenceoflengthKwiththelargestsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * First we sorted elements.
 * Then selected higher ones and counted them by map.
 * Then got from queue, checked count and if count is available put the new array.
 */

public class Main {
    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        int[] result = mySolution.maxSubsequence(new int[]{-16, -13, 8, 16, 35, -17, 30, -8, 34, -2, -29, -35, 15, 13, -30, -34, 6, 15, 28, -23, 34, 28, -24, 15, -17, 10, 31, 32, -3, -36, 19, 31, -5, -21, -33, -18, -23, -37, -15, 12, -28, -40, 1, 38, 38, -38, 33, -35, -28, -40, 4, -15, -29, -33, -18, -9, -29, 20, 1, 36, -8, 23, -34, 16, -7, 13, 39, 38, 7, -7, -10, 30, 9, 26, 27, -37, -18, -25, 14, -36, 23, 28, -15, 35, -9, 1}, 8);
        System.out.println(Arrays.toString(result));
    }
}

class MySolution {
    public int[] maxSubsequence(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        if (k >= nums.length) {
            return nums.clone();
        }

        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        Map<Integer, Integer> subElementByCount = new HashMap<>();
        for (int i = nums.length - k; i < nums.length; i++) {
            int val = sorted[i];
            subElementByCount.put(val, subElementByCount.getOrDefault(val, 0) + 1);
        }

        int[] result = new int[k];
        int resultIndex = 0;
        for (int num : nums) {
            if (subElementByCount.getOrDefault(num, 0) > 0) {
                result[resultIndex++] = num;
                subElementByCount.put(num, subElementByCount.get(num) - 1);
                if (resultIndex == k) {
                    break;
                }
            }
        }

        return result;
    }
}
