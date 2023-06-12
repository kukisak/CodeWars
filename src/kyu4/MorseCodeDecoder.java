package kyu4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static kyu6.MorseCodeDecoder.MorseCode;

public class MorseCodeDecoder {
    /**
     * When transmitting the Morse code, the international standard specifies that:
     *
     * "Dot" – is 1 time unit long = (x * 1) * 1 = opt1
     * "Dash" – is 3 time units long = (x * 3) * 1 = opt2.
     * Pause between dots and dashes in a character – is 1 time unit long = (x * 1) * 0 = opt3.
     * Pause between characters inside a word – is 3 time units long = (x * 3) * 0 = opt4.
     * Pause between words – is 7 time units long = (x * 7) * 0 = opt5.
     *
     * @param bits given stream of 1s and 0s to convert to morse code
     * @return converted bits to morse code where pause between chars is " " and pause between words is "   ".
     */
    public static String decodeBits(String bits) {
        if (bits.length() == 0) {
            return "";
        }
        bits = trim0s(bits);
        int timeUnit = getTimeUnit(analyzeLength(bits));
        List<String> bitsGroup = new ArrayList<>();
        char beginChar = bits.charAt(0);
        int beginIndex = 0;
        for (int i = 0; i < bits.length(); i++) {
            if (bits.charAt(i) != beginChar) {
                bitsGroup.add(bits.substring(beginIndex, i));
                beginChar = bits.charAt(i);
                beginIndex = i;
            }
            if (i == bits.length() - 1) {
                bitsGroup.add(bits.substring(beginIndex, i+1));
            }
        }
        return bitsGroup.stream().filter(str -> !str.isEmpty())
                .map(group -> mapBitsToMorse(group, timeUnit))
                .collect(Collectors.joining());
    }
    public static String decodeMorse(String morseCode) {
        return Arrays.stream(morseCode.trim().split("   "))
                .map(word -> Arrays.stream(word.split(" "))
                        .map(MorseCode::get)
                        .filter(Objects::nonNull)
                        .reduce("", String::concat))
                .collect(Collectors.joining(" "));
    }

    protected static String mapBitsToMorse(String bitsGroup, int timeUnit) {
        int length = bitsGroup.length() / timeUnit;
        if (bitsGroup.contains("1")) {
            return (length == 3) ? "-" : ".";
        } else if (bitsGroup.contains("0")){
            return switch (length) {
                case 3 -> " ";
                case 7 -> "   ";
                default -> "";
            };
        } else {
            throw new UnsupportedOperationException("Unexpected bits group " + bitsGroup);
        }
    }

    protected static String trim0s(String bits) {
        int first1index = bits.indexOf("1");
        int last1index = bits.lastIndexOf("1");
        if (first1index < 0) {
            return "";
        } else {
            return bits.substring(first1index, last1index+1);
        }
    }

    static class AnalyzedLength {
        private int first1sLength;
        private int first0sLength;
        private int nextDiff1sLength;
        private int nextDiff0sLength;

        public AnalyzedLength() {
        }

        public AnalyzedLength(int first1sLength, int first0sLength, int nextDiff1sLength, int nextDiff0sLength) {
            this.first1sLength = first1sLength;
            this.first0sLength = first0sLength;
            this.nextDiff1sLength = nextDiff1sLength;
            this.nextDiff0sLength = nextDiff0sLength;
        }

        public int getFirst1sLength() {
            return first1sLength;
        }

        public int getFirst0sLength() {
            return first0sLength;
        }

        public int getNextDiff1sLength() {
            return nextDiff1sLength;
        }

        public int getNextDiff0sLength() {
            return nextDiff0sLength;
        }

        public void setFirst1sLength(int first1sLength) {
            this.first1sLength = first1sLength;
        }

        public void setFirst0sLength(int first0sLength) {
            this.first0sLength = first0sLength;
        }

        public void setNextDiff1sLength(int nextDiff1sLength) {
            this.nextDiff1sLength = nextDiff1sLength;
        }

        public void setNextDiff0sLength(int nextDiff0sLength) {
            this.nextDiff0sLength = nextDiff0sLength;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AnalyzedLength that = (AnalyzedLength) o;

            if (first1sLength != that.first1sLength) return false;
            if (first0sLength != that.first0sLength) return false;
            if (nextDiff1sLength != that.nextDiff1sLength) return false;
            return nextDiff0sLength == that.nextDiff0sLength;
        }

        @Override
        public int hashCode() {
            int result = first1sLength;
            result = 31 * result + first0sLength;
            result = 31 * result + nextDiff1sLength;
            result = 31 * result + nextDiff0sLength;
            return result;
        }

        @Override
        public String toString() {
            return "AnalyzedLength{" +
                    "first1sLength=" + first1sLength +
                    ", first0sLength=" + first0sLength +
                    ", nextDiff1sLength=" + nextDiff1sLength +
                    ", nextDiff0sLength=" + nextDiff0sLength +
                    '}';
        }
    }

    /**
     * Analyze given stream of bits and find length of first group of 1s,
     * first group of 0s, length of next group of 1s with different length and
     * length of next group of 0s with different length.
     * If there are no such mentioned groups of digits then use 0 instead.
     * @param bits givne stream of bits
     * @return AnalyzedLength object with filled length fields
     */
    protected static AnalyzedLength analyzeLength(String bits) {
        AnalyzedLength result = new AnalyzedLength();
        List<String> array1s = Arrays.stream(bits.split("(0+)")).filter(str -> !str.isEmpty()).toList();
        List<String> array0s = Arrays.stream(bits.split("(1+)")).filter(str -> !str.isEmpty()).toList();

        result.setFirst1sLength(array1s.size() > 0 ? array1s.get(0).length() : 0);
        result.setFirst0sLength(array0s.size() > 0 ? array0s.get(0).length() : 0);

        result.setNextDiff1sLength(array1s.stream()
                .filter(group -> group.length() != result.getFirst1sLength())
                .mapToInt(String::length)
                .findFirst().orElse(0));
        result.setNextDiff0sLength(array0s.stream()
                .filter(group -> group.length() != result.getFirst0sLength())
                .mapToInt(String::length)
                .findFirst().orElse(0));
        return result;
    }
    protected static int getTimeUnit(AnalyzedLength analyzedLength) {
        return getTimeUnit(
                analyzedLength.getFirst1sLength(),
                analyzedLength.getFirst0sLength(),
                analyzedLength.getNextDiff1sLength(),
                analyzedLength.getNextDiff0sLength());
    }
    /**
     * Calculate timeunit x (via following equations) of morse code based on following arguments.
     *   dot = (x * 1) * 1 = opt1
     *   dash = (x * 3) * 1 = opt2
     *   pause between dot and dash in char = (x * 1) * 0 = opt3
     *   pause between chars in a char = (x * 3) * 0 = opt4
     *   pause between words = (x * 7) * 0 = opt5
     *
     * @param first1sLength length of binary morse code for first group of 1s
     * @param first0sLength length of binary morse code for first group of 0s
     * @param nextDiff1sLength length of binary morse code for next different group of 1s
     *                         or 0 length if there is no more different group of 1s
     * @param nextDiff0sLength length of binary morse code for next different group of 1s
     *                         or 0 lenght if there is no more different group of 0s
     * @return time unit of 1 dot character
     */
    protected static int getTimeUnit(int first1sLength, int first0sLength, int nextDiff1sLength, int nextDiff0sLength) {
        if (first1sLength == 0 || nextDiff1sLength == 0) {
            return first1sLength;
        }
        if (first1sLength != nextDiff1sLength) {
            return Math.min(first1sLength, nextDiff1sLength);
        } else {
            if (first0sLength != nextDiff0sLength) {
                if (first0sLength > nextDiff0sLength) {
                    int tmp = first0sLength;
                    first0sLength = nextDiff0sLength;
                    nextDiff0sLength = tmp;
                }
                if (nextDiff0sLength % 7 == first0sLength % 3) {
                    return first0sLength % 3;
                } else {
                    return first0sLength;
                }
            } else {
                return first0sLength;
            }
        }
    }
}
