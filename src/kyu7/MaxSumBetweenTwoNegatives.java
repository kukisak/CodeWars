package kyu7;

import static java.lang.Math.max;

public class MaxSumBetweenTwoNegatives {
    public static int maxSum(int[] arr) {
        int result = -1;
        int indexA = -1;
        int tempResult = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0){
                if (indexA > -1) {
                    result = max(tempResult, result);
                }
                indexA = i;
                tempResult = 0;
            } else if (arr[i] >= 0){
                if (indexA > -1) {
                    tempResult += arr[i];
                }
            }
        }
        return result;
    }
}