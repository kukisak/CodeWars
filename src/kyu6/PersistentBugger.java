package kyu6;

import java.util.Arrays;

public class PersistentBugger {
    public static int persistence(long n) {
        if (n <= 9) {
            return 0;
        } else {
            return 1 + persistence(Arrays.stream(String.valueOf(n).split(""))
                    .mapToLong(Long::parseLong)
                    .reduce(1L, (a,b) -> a*b));
        }
    }
}
