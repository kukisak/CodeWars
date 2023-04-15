package kyu8;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class FindTheNeedle {
    public static String findNeedle(Object[] haystack) {
        OptionalInt result = IntStream.range(0, haystack.length)
                .filter(i -> "needle".equals(haystack[i]))
                .findFirst();
        if (result.isPresent()) {
            return "found the needle at position " + result.getAsInt();
        } else {
            return null;
        }
    }

    public String findNeedleBest(Object[] haystack) {
        return "found the needle at position " + Arrays.asList(haystack).indexOf("needle");
    }
}
