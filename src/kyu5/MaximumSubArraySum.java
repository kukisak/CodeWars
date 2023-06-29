package kyu5;

import java.util.Arrays;

public class MaximumSubArraySum {
    public static int sequence(int[] arr) {
        int[][] resultsTable = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            resultsTable[i][i] = arr[i];
        }
        int maximumSum = 0;
        for (int column = 0; column < arr.length; column++) {
            for (int row = 0; row < column; row++) {
                resultsTable[column][row] = resultsTable[column-1][row] + resultsTable[column][column];
                maximumSum = Math.max(maximumSum, resultsTable[column][row]);
            }
        }
        return maximumSum;
    }

    public static int sequenceClever(int[] arr) {
        int max_ending_here = 0, max_so_far = 0;
        for (int v : arr) {
            max_ending_here = Math.max(0, max_ending_here + v);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }
        return max_so_far;
    }

    public static int sequenceCleverViaStream(int[] arr) {
        final int[] max = {0};
        return Arrays.stream(arr).map(i -> max[0] = Math.max(i + max[0], 0)).max().orElse(0);
    }
}
