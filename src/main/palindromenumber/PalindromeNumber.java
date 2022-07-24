package main.palindromenumber;

/**
 * Given an integer x, return true if x is palindrome integer.
 * <p>
 * An integer is a palindrome when it reads the same backward as forward.
 */

public class PalindromeNumber {
    //First try :)
    boolean isPalindrome(int number) {
        if (number < 0)
            return false;

        int actualNumber = number;
        int palindrome = 0;

        while (number >= 10) {
            int remainder = number % 10;

            if (palindrome == 0) {
                palindrome = remainder;
            } else {
                palindrome = palindrome * 10 + remainder;
            }

            number /= 10;
        }
        palindrome = palindrome * 10 + number;

        return palindrome == actualNumber;
    }

    boolean betterWay(int number) {
        if (number < 0)
            return false;

        if (number < 10)
            return true;

        int actualNumber = number;
        int palindrome = 0;
        int remainder;

        while (number >= 10) {
            remainder = number % 10;
            //Because we check if number is less than 10,
            //no need to check if it is the first element of palindrome
            palindrome = palindrome * 10 + remainder;
            number /= 10;
        }
        palindrome = palindrome * 10 + number;

        return palindrome == actualNumber;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        boolean isPalindrome = palindromeNumber.betterWay(1001);
        System.out.println(isPalindrome);
    }
}
