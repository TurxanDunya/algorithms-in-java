package main.validparanthesis;

public class Main {
    public static void main(String[] args) {
        var mySolution = new MySolutionWithStack();

        String given = "([}}])";
        System.out.println(mySolution.isValid(given));
    }
}
