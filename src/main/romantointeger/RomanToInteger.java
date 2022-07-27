package main.romantointeger;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    //First try :)
    int romanToInt(String givenValue) {
        int expectedValue = 0;

        Map<Character, Integer> mapRomanToOrderIndex = new HashMap<>();
        mapRomanToOrderIndex.put('I', 1);
        mapRomanToOrderIndex.put('V', 5);
        mapRomanToOrderIndex.put('X', 10);
        mapRomanToOrderIndex.put('L', 50);
        mapRomanToOrderIndex.put('C', 100);
        mapRomanToOrderIndex.put('D', 500);
        mapRomanToOrderIndex.put('M', 1000);

        Integer currentCharValue;
        Integer nextCharValue;
        char currentChar;
        char nextChar;
        int subtractedValue;

        boolean mustAddLastElement = true;
        int givenValueLength = givenValue.toCharArray().length;
        for (int index = 0; index < givenValueLength - 1; index++) {
            currentChar = givenValue.charAt(index);
            nextChar = givenValue.charAt(index + 1);

            currentCharValue = mapRomanToOrderIndex.get(currentChar);
            nextCharValue = mapRomanToOrderIndex.get(nextChar);
            if (currentCharValue >= nextCharValue) {
                expectedValue += currentCharValue;
                continue;
            }

            //If currentCharValue < nextCharValue
            subtractedValue = nextCharValue - currentCharValue;
            expectedValue += subtractedValue;
            index++;

            if (index == givenValueLength - 1)
                mustAddLastElement = false;
        }

        if (mustAddLastElement)
            expectedValue += mapRomanToOrderIndex.get(givenValue.charAt(givenValueLength - 1));

        return expectedValue;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        int result = romanToInteger.romanToInt("MDCXCV");
        System.out.println(result);
    }

}
