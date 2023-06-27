package kyu5;

import java.util.Map;
import java.util.Stack;

public class DirReduction {

    public static final Map<String, String> OPPOSITE_PAIRS = Map.of(
            "NORTH", "SOUTH",
            "SOUTH", "NORTH",
            "EAST", "WEST",
            "WEST", "EAST"
    );
    public static String[] dirReduc(String[] arr) {
        Stack<String> stack = new Stack<>();
        for (String direction : arr) {
            if (!stack.isEmpty() && stack.peek().equalsIgnoreCase(OPPOSITE_PAIRS.get(direction))){
                stack.pop();
            } else {
                stack.push(direction);
            }
        }
        return stack.toArray(new String[0]);
    }
}
