package kyu5;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RgbToHex {
    public static String rgb(int r, int g, int b) {
        return String.format("%2S%2S%2S",
                        Integer.toHexString(roundToByte(r)),
                        Integer.toHexString(roundToByte(g)),
                        Integer.toHexString(roundToByte(b)))
                .replaceAll(" ", "0");
    }

    public static int roundToByte(int number) {
        return Math.min(255, Math.max(0, number));
    }

    public static String rgbClever(int r, int g, int b) {
        return Stream.of(r, g, b)
                .map(val -> Math.max(0, val))
                .map(val -> Math.min(255, val))
                .map(val -> String.format("%02X", val))
                .collect(Collectors.joining());
    }
}
