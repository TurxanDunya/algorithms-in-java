package main.longestcommonprefix;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        String result1 = mySolution.longestCommonPrefix(new String[]{"ab", "a"});
        System.out.println(result1);

        BetterSolution betterSolution = new BetterSolution();
        String result2 = betterSolution.longestCommonPrefix(new String[]{"ab", "a"});
        System.out.println(result2);
    }

    static class MySolution {
        public String longestCommonPrefix(String[] strs) {
            int givenStrsLength = strs.length;

            String commonPrefix = "";
            int letterIndex = 0;

            while (true) {
                char[] lineOfCharsInStrs = new char[givenStrsLength];

                if (lineOfCharsInStrs.length == 0) {
                    return "";
                }

                int arrIndex = 0;
                for (String str : strs) {
                    if (str.isEmpty()) {
                        return commonPrefix;
                    }

                    char[] strCharArray = str.toCharArray();
                    if (strCharArray.length - 1 < letterIndex) {
                        return commonPrefix;
                    }

                    char currentLetter = strCharArray[letterIndex];
                    lineOfCharsInStrs[arrIndex] = currentLetter;
                    arrIndex++;
                }

                if (lineOfCharsInStrs.length == 1) {
                    commonPrefix = commonPrefix + lineOfCharsInStrs[0];
                    return commonPrefix;
                }

                int i;
                for (i = 0; i < lineOfCharsInStrs.length - 1; i++) {
                    if (lineOfCharsInStrs[i] != lineOfCharsInStrs[i + 1]) {
                        return commonPrefix;
                    }
                }

                commonPrefix = commonPrefix + lineOfCharsInStrs[i];
                letterIndex++;
            }
        }
    }

    static class BetterSolution {
        public String longestCommonPrefix(String[] strs) {
            Arrays.sort(strs);
            String s1 = strs[0];
            String s2 = strs[strs.length - 1];
            int idx = 0;
            while (idx < s1.length() && idx < s2.length()) {
                if (s1.charAt(idx) == s2.charAt(idx)) {
                    idx++;
                } else {
                    break;
                }
            }
            return s1.substring(0, idx);
        }
    }

}
