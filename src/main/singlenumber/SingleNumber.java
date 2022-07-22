package main.singlenumber;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */

class SingleNumber {

    //first try :)
    int singleNumber(int[] nums) {
        Map<Integer, Integer> mapElementByElementCount = new HashMap<>();

        for (int num : nums) {
            Integer element = mapElementByElementCount.get(num);
            if (element == null) {
                mapElementByElementCount.put(num, 1);
            } else {
                mapElementByElementCount.put(num, 2);
            }
        }

        for (Map.Entry<Integer, Integer> entry : mapElementByElementCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return 0;
    }

    //better way is using xor operator in java
    public int singleNumberBetterWay(int[] nums) {
        int xor = 0;
        for (int n : nums) xor = xor ^ n;
        return xor;
    }

    public static void main(String[] args) {
        var singleNumber = new SingleNumber();
        int result = singleNumber.singleNumberBetterWay(new int[]{2, 2, 5});
        System.out.println(result);
    }
}
