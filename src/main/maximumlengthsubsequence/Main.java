package main.maximumlengthsubsequence;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.maximumLength(new int[]{1, 1, 7, 3, 2});
        System.out.println(result);
    }
}

/**
 * Possibilities, and patterns created for this possibilities:
 * 1. All elements are even.
 * 2. All elements are odd.
 * 3. Elements at odd indices are odd, and elements at even indices are even.
 * 4. Elements at odd indices are even, and elements at even indices are odd.
 */
class Solution {
    public int maximumLength(int[] nums) {
        int res = 0;
        int[][] patterns = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        for (int[] pattern : patterns) {
            int cnt = 0;
            for (int num : nums) {
                if (num % 2 == pattern[cnt % 2]) {
                    cnt++;
                }
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
