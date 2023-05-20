package kyu6;

import java.util.Arrays;

public class DigitalRoot {
    public static int digital_root(int n) {
        int result = Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).sum();
        if (result > 9){
            return digital_root(result);
        }
        return result;
    }

    public static int digital_root_clever(int n) {
        return (n != 0 && n % 9 == 0) ? 9 : n % 9;
    }
}
