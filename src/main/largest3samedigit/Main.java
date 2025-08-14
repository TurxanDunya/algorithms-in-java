package main.largest3samedigit;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.largestGoodInteger("2300019");
        System.out.println(result);
    }
}

class Solution {
    public String largestGoodInteger(String num) {
        if (num.isEmpty()) {
            return "";
        }

        String[] numAsCharArray = num.split("");

        int currentStreak = 0;
        int maxStreak = -1;
        int lastElement = -1;
        for (String currentElement : numAsCharArray) {
            int currentElementAsInt = Integer.parseInt(currentElement);
            if (lastElement == -1) {
                lastElement = currentElementAsInt;
                currentStreak++;
                continue;
            }

            if (lastElement == currentElementAsInt) {
                currentStreak++;
            } else {
                lastElement = currentElementAsInt;
                currentStreak = 1;
                continue;
            }

            if (currentStreak == 3) {
                if (maxStreak < currentElementAsInt) {
                    maxStreak = currentElementAsInt;
                }

                currentStreak = 1;
            }
        }

        if (maxStreak == -1) {
            return "";
        }

        return maxStreak == 0 ? "000" : String.valueOf(maxStreak * 111);
    }
}