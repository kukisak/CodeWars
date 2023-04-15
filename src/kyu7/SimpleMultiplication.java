package kyu7;

public class SimpleMultiplication {
    public static int simpleMultiplication(int n) {
        return (n % 2 == 0) ? n*8 : n*9;
    }

    public static int simpleMultiplicationClever(int n) {
        return n * (n % 2 + 8);
    }
}
