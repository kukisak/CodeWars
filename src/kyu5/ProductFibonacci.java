package kyu5;

import java.util.stream.Stream;

public class ProductFibonacci {
    public static long[] productFib(long prod) {
        long fn, fn1 = 0, fn2 = 1;
        while (fn1 * fn2 < prod) {
            fn = fn1;
            fn1 = fn2;
            fn2 = fn + fn1;
        }
        return new long[] {fn1, fn2, (fn1 * fn2 == prod) ? 1 : 0};
    }
    public static long[] productFibClever(long prod) {
        long fn = 0, fn1 = 1;
        while (fn * fn1 < prod) {
            fn1 = fn1 + fn;
            fn = fn1 - fn;
        }
        return new long[] {fn, fn1, (fn * fn1 == prod) ? 1 : 0};
    }
    public static long[] productFibCleverStream(long prod) {
        return Stream.iterate(new long[] {0, 1}, array -> new long[] {array[1], array[0] + array[1] })
                .filter(array -> array[0] * array[1] >= prod)
                .findFirst()
                .map(array -> new long[]{array[0], array[1], array[0] * array[1] == prod ? 1 : 0})
                .get();
    }
}
