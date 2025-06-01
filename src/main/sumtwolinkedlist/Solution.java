package main.sumtwolinkedlist;

// But this solution has a problem.
// WHAT IF numbers in the list is greater than long size? Look solution 2.
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long numberOne = getNumberFromList(l1);
        long numberTwo = getNumberFromList(l2);

        long sum = numberOne + numberTwo;
        if (sum == 0) {
            return new ListNode(0);
        }

        boolean isFirstNode = true;
        ListNode resultNode = null;
        while (sum != 0) {
            int valueToAddNode = (int) (sum % 10);
            sum /= 10;

            if (isFirstNode) {
                resultNode = new ListNode(valueToAddNode);
                isFirstNode = false;
            } else {
                ListNode cursorNode = resultNode;
                while (cursorNode.next != null) {
                    cursorNode = cursorNode.next;
                }
                cursorNode.next = new ListNode(valueToAddNode);
            }
        }

        return resultNode;
    }

    private static long getNumberFromList(ListNode l1) {
        long numberOne = 0;
        long multiplierPerLoopForNumberOne = 1;
        ListNode currentNodeL1 = l1;
        while (currentNodeL1 != null) {
            numberOne += currentNodeL1.val * multiplierPerLoopForNumberOne;
            multiplierPerLoopForNumberOne *= 10;
            currentNodeL1 = currentNodeL1.next;
        }
        return numberOne;
    }

    public static void main(String[] args) {
        ListNode result = addTwoNumbers(
                new ListNode(9),
                new ListNode(1, new ListNode(9)));
        System.out.println(result);
    }
}
