package kyu4;

public class MorseCodeDecoder {
    /**
     * When transmitting the Morse code, the international standard specifies that:
     *
     * "Dot" – is 1 time unit long.
     * "Dash" – is 3 time units long.
     * Pause between dots and dashes in a character – is 1 time unit long.
     * Pause between characters inside a word – is 3 time units long.
     * Pause between words – is 7 time units long.
     *
     * @param bits
     * @return
     */
    public static String decodeBits(String bits) {
        // dot = (x * 1) * 1 = opt1
        // dash = (x * 3) * 1 = opt2
        // pause between dot and dash in char = (x * 1) * 0 = opt3
        // pause between chars in a char = (x * 3) * 0 = opt4
        // pause between words = (x * 7) * 0 = opt5
        String[] digits = bits.split("\\d");
        /**
         * trim 0s
         * get first 1s count
         * get first 0s count
         * get next different 1s count
         * get next different 0s count
        */
        return ".";
    }

    public static String decodeMorse(String morseCode) {
        return kyu6.MorseCodeDecoder.decode(morseCode);
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
    public static int getTimeUnit(int first1sLength, int first0sLength, int nextDiff1sLength, int nextDiff0sLength) {
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
