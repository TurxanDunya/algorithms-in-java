package main.plusone;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var mySolution = new MyAndBestSolution();
        int[] result = mySolution.plusOne(new int[]{9});
        System.out.println(Arrays.toString(result));
    }
}
