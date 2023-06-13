package kyu4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static kyu6.MorseCodeDecoder.MorseCode;

public class MorseCodeDecoderClever {
    /**
     * Decode input string of 1s and 0s to morse code
     * It consists of following steps:
     * - trim leading and trailing 0s
     * - identify rate
     * - decode bits to morse
     * @param bits input string of 1s and 0s
     * @return decoded morse code
     */
    public static String decodeBits(String bits) {
        bits = bits.replaceAll("^0+|0+$","");
        StringBuilder morse = new StringBuilder();
        int rate = getRate(bits);
        for (String word : bits.split("0{" + 7 * rate + "}")) {
            for (String character : word.split("0{" + 3 * rate + "}")) {
                for (String symbol : character.split("0{" + rate + "}")) {
                    morse.append((symbol.length() / rate == 3) ? "-" : ".");
                }
                morse.append(" ");
            }
            morse.append("  ");
        }
        return morse.toString().trim();
    }

    /**
     * Get rate of bits where all the information group is multiplied by.
     * @param bits input string of 0s and 1s to identify rate from
     * @return identified rate
     */
    public static int getRate(String bits) {
        Matcher matcher = Pattern.compile("(1+|0+)").matcher(bits);
        int rate = Integer.MAX_VALUE;
        while (matcher.find()) {
            rate = Math.min(rate, matcher.group().length());
        }
        return rate;
    }

    /**
     * Decode input morse code to english sentence
     * @param morseCode input morse code
     * @return decoded english sentence
     */
    public static String decodeMorse(String morseCode) {
        StringBuilder english = new StringBuilder();
        for (String word : morseCode.split("   ")) {
            for (String letter : word.split(" ")) {
                english.append(MorseCode.get(letter));
            }
            english.append(" ");
        }
        return english.toString().trim();
    }
}