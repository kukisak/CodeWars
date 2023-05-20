package kyu7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FindOddNumber {
    public static int findIt(int[] a) {
        Arrays.sort(a);
        int counter = 0;
        int currentVal = a[0];
        for (int val: a) {
            if (val == currentVal) {
                counter++;
            } else {
                if (counter % 2 == 1) {
                    return currentVal;
                } else {
                    counter = 1;
                    currentVal = val;
                }
            }
        }
        if (counter % 2 == 1) {
            return currentVal;
        } else {
            return 0;
        }
    }

    public static int findItClever(int[] a){
        int xor = 0;
        for (int val: a) {
            xor ^= val;
        }
        return xor;
    }

    public static int findItClever2(int[] a) {
        List<Integer> integerList = Arrays.stream(a).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        for (int val: a) {
            if (Collections.frequency(integerList, val) % 2 == 1){
                return val;
            }
        }
        return 0;
    }

    public static int findItClever3(int[] a) {
        return Arrays.stream(a).boxed()
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet().stream()
                .filter(pair -> pair.getValue() % 2 == 1)
                .findFirst().orElseThrow()
                .getKey();
    }
}
