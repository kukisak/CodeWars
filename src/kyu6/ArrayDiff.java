package kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayDiff {
    public static int[] arrayDiff(int[] a, int[] b) {
        var list = new ArrayList<>(Arrays.stream(a).boxed().toList());
        list.removeAll(Arrays.stream(b).boxed().toList());
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] arrayDiffClever(int[] a, int[] b) {
        return IntStream.of(a).filter(x -> IntStream.of(b).noneMatch(y -> y == x)).toArray();
    }
}
