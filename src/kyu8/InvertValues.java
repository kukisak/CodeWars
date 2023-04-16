package kyu8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvertValues {
    public static int[] invert(int[] array) {
        List<Integer> result = new ArrayList<>(array.length);
        for (int j : array) {
            result.add(-j);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static int[] invertBest(int[] array) {
        return Arrays.stream(array).map(i -> -i).toArray();
    }
}
