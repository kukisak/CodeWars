package kyu6;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FindOutlier {
    static int find(int[] integers){
        int odd = 0;
        int even = 0;
        for (int i = 0; i < 3; i++) {
            if (integers[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        IntPredicate oddPredicate = value -> Math.abs(value % 2) == 1;
        if (odd > even) {
            oddPredicate = oddPredicate.negate();
        }
        return IntStream.of(integers).filter(oddPredicate).findFirst().orElseThrow();
    }

    static int findClever(int[] integers) {
        // We only need the first 3 integers to determine whether we are chasing odds or evens.
        // So, take the first 3 integers and compute the value of Math.abs(i) % 2 on each of them.
        // It will be 0 for even numbers and 1 for odd numbers.
        // Now, add them. If sum is 0 or 1, then we are chasing odds. If sum is 2 or 3, then we are chasing evens.
        int sum = Arrays.stream(integers).limit(3).map(i -> Math.abs(i) % 2).sum();
        int mod = (sum == 0 || sum == 1) ? 1 : 0;
        return Arrays.stream(integers).parallel()
                .filter(n -> Math.abs(n) % 2 == mod).findFirst().orElseThrow();
    }
}
