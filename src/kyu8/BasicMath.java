package kyu8;

public class BasicMath {
    public static Integer basicMath(String op, int v1, int v2)
    {
        switch (op) {
            case "+" -> {return v1 + v2;}
            case "-" -> {return v1 - v2;}
            case "*" -> {return v1 * v2;}
            case "/" -> {return v1 / v2;}
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
    }
}
