package main.removeelement;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int lastCursorIndex = nums.length - 1;
        int currentIndex = 0;
        while (currentIndex <= lastCursorIndex) {
            if (nums[currentIndex] == val) {
                nums[currentIndex] = nums[lastCursorIndex--];
            } else {
                currentIndex++;
            }
        }

        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
        return lastCursorIndex + 1;
    }
}
