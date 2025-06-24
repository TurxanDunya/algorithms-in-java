package main.validparanthesis;

import java.util.Stack;

public class MySolutionWithStack {
    public boolean isValid(String parentheses) {
        if (parentheses == null || parentheses.isEmpty()) {
            return true;
        }

        if (parentheses.length() % 2 != 0) {
            return false;
        }

        char[] parenthesesCharArray = parentheses.toCharArray();

        try {
            Stack<Character> stack = new Stack<>();
            for (char element : parenthesesCharArray) {
                if (element == ')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }

                if (element == '}' && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }

                if (element == ']' && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }

                stack.push(element);
            }

            if (stack.isEmpty()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }
}
