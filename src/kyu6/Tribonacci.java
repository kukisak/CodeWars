package kyu6;

import java.util.Arrays;
import java.util.stream.Stream;

public class Tribonacci {
    public double[] tribonacci(double[] s, int n) {
        double[] result = new double[n];
        System.arraycopy(s, 0, result, 0, Math.min(s.length, n));
        for (int i = 3; i < n; i++) {
            result[i] = result[i-1] + result[i-2] + result[i-3];
        }
        return result;
    }

    public double[] tribonacciBest(double[] s, int n) {
        double[] result = Arrays.copyOf(s, n);
        for (int i = 3; i < n; i++) {
            result[i] = result[i-1] + result[i-2] + result[i-3];
        }
        return result;
    }

    public double[] tribonacciClever(double[] s, int n) {
        return Stream.iterate(s, tuple -> new double[]{tuple[1], tuple[2], tuple[0] + tuple[1] + tuple[2]})
                .limit(n)
                .mapToDouble(tuple -> tuple[0])
                .toArray();
    }
}
