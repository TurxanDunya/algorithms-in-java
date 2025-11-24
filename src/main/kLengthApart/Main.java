package main.kLengthApart;

public class Main {
    public static void main(String[] args) {
        boolean result = kLengthApart(new int[]{0, 1, 0, 0, 1, 0, 0, 1}, 2);
        System.out.println(result);
    }

    public static boolean kLengthApart(int[] nums, int k) {
        int lastIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastIndex != -1 && i - lastIndex - 1 < k) {
                    return false;
                }
                lastIndex = i;
            }
        }

        return true;
    }
}
