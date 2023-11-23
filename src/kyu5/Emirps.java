package kyu5;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

class Emirps {

    public static long[] findEmirp(long n) {
        Set<Long> primes = primeNumbersTill(n);
        List<Long> emirpsList = primes.stream()
                .filter(prime -> prime <= n)
                .map(prime -> {
                    long swappedPrime = swapDigits(prime);
                    if (prime == swappedPrime) {
                        return null;
                    }
                    if (!primes.contains(swappedPrime)) {
                        return null;
                    }
                    return prime;
                })
                .filter(Objects::nonNull)
                .toList();
        long[] result = {0,0,0};
        result[0] = emirpsList.size(); 
        result[1] = emirpsList.stream().max(Comparator.comparingLong(Long::longValue)).orElse(0L);
        result[2] = emirpsList.stream().mapToLong(Long::longValue).sum();
        return result;
    }

    public static Set<Long> primeNumbersTill(long n) {
        return LongStream.rangeClosed(2, getMaxGeneratedPrime(n))
                .filter(Emirps::isPrime).boxed()
                .collect(Collectors.toSet());
    }

    private static boolean isPrime(long number) {
        return LongStream.rangeClosed(2, Double.valueOf(Math.sqrt(number)).longValue())
                .allMatch(n -> number % n != 0);
    }

    private static long swapDigits(long numberToSwap) {
        return Long.parseLong(new StringBuilder(String.valueOf(numberToSwap)).reverse().toString());
    }
    
    private static long getMaxGeneratedPrime(long n) {
        int numberOfDigits = String.valueOf(n).length();
        return Long.parseLong("9".repeat(numberOfDigits));
    }
}
