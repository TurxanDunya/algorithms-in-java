package main.largesttrianglearea;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        double area = solution.largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 3}, {3, 0}});
        System.out.println(area);
    }
}

class Solution {
    public double largestTriangleArea(int[][] points) {
        int largestX = 0;
        int largestY = 0;
        for (int[] point : points) {
            if (point[0] > largestX) {
                largestX = point[0];
            }

            if (point[1] > largestY) {
                largestY = point[1];
            }
        }

        return largestX * largestY / 2.0;
    }
}