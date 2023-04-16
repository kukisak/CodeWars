package kyu7;

import java.util.Stack;

public class ValidParentheses {
    public static boolean validParentheses(String parenStr) {
        final Integer[] level = new Integer[] {0};
        final Boolean[] flags = new Boolean[] {true};
        parenStr.chars().takeWhile((ch) -> flags[0]).forEach(parent -> {
            if (parent == '('){
                level[0]++;
            } else if (parent == ')') {
                if (level[0] == 0) {
                    flags[0] = false;
                }
                level[0]--;
            }
        });
        return (level[0] == 0) && (flags[0]);
    }

    public static boolean validParenthesesBest(String parenStr) {
        final Stack<Integer> stack = new Stack<>();
        final Boolean[] flags = new Boolean[] {true};
        parenStr.chars().takeWhile((ch) -> flags[0]).forEach(parent -> {
            if (parent == '('){
                stack.push(parent);
            } else if (parent == ')') {
                if (stack.isEmpty()) {
                    flags[0] = false;
                } else {
                    stack.pop();
                }
            }
        });
        return stack.isEmpty() && flags[0];
    }

    public static boolean validParenthesesClever(String parenStr) {
        while (parenStr.contains("()")) {
            parenStr = parenStr.replace("()", "");
        }
        return parenStr.equals("");
    }
}
