package kyu6;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreatePhoneNumber {
    public static String createPhoneNumber(int[] numbers) {
        var text = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining());
        return String.format("(%s) %s-%s", text.substring(0,3), text.substring(3,6), text.substring(6,10));
    }

    public static String createPhoneNumberClever(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", IntStream.of(numbers).boxed().toArray());
    }

}
