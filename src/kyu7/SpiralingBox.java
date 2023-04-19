package kyu7;

public class SpiralingBox {
    public static int[][] createBox(int width, int length) {
        int[][] resultBox = new int[length][width];
        for (int currentLen = 0; currentLen < length; currentLen++) {
            for (int currentWid = 0; currentWid < width; currentWid++) {
                resultBox[currentLen][currentWid] = calcValue(currentLen, currentWid, length, width);
            }
        }
        return resultBox;
    }

    public static int calcValue(int currentLen, int currentWid, int maxLen, int maxWid) {
        return Math.min(getValueFor(currentWid, maxWid), getValueFor(currentLen, maxLen));
    }

    private static int getValueFor(int current, int max) {
        int valueLen;
        if (current >= max /2) {
            valueLen = max - current;
        } else {
            valueLen = (current + 1);
        }
        return valueLen;
    }

    public static void print(int[][] box) {
        for (int len = 0; len < box.length; len++) {
            for (int wid = 0; wid < box[0].length; wid++) {
                System.out.print(box[len][wid]);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
