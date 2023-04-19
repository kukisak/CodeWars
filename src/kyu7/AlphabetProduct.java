package kyu7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlphabetProduct {
/*
I have four positive integers, A, B, C and D, where A < B < C < D. The input is a list of the integers A, B, C, D, AxB, BxC, CxD, DxA in some order. Your task is to return the value of D.
Algorithm
    a) sort the numbers by size ASC
       => the order of input and results can be mixed so I have to look for the second number and the product
    b) apply logic
      first input number is known
      iterate through array and find the second input number and computed product
 */

    public static int alphabet(int[] input) {
        List<Integer> listOfNumbers = Arrays.stream(input).sorted().boxed().collect(Collectors.toCollection(ArrayList::new));

        int A, B, C, D;
        System.out.println(listOfNumbers.toString());
        A = listOfNumbers.remove(0);
        B = findSecondInputNumber(listOfNumbers, A);
        C = findSecondInputNumber(listOfNumbers, B);
        D = findSecondInputNumber(listOfNumbers, C);
        return D;
    }

    /*
      Find second input number of the procuct, remove it from the input list and also remove the product from the input list
      input - list of numbers (including priduct) without the first number
      Return second input number of the product
     */
    private static int findSecondInputNumber(List<Integer> input, int firstNumber) {
        int productIndex;
        int secondNumber = -1;
        for (int secondNumberIndex = 0; secondNumberIndex < input.size(); secondNumberIndex++) {
            productIndex = secondNumberIndex + 1;
            productIndex = findProductIndex(input, firstNumber, (int) input.get(secondNumberIndex), productIndex);
            if (productIndex > -1) {
                input.remove(productIndex);
                secondNumber = input.remove(secondNumberIndex);
                break;
            }
        }
        if (secondNumber == -1) {
            throw new IllegalStateException("Not found second number for the first number " + firstNumber);
        }
        return secondNumber;
    }

    private static int findProductIndex(List<Integer> input,
                                        int firstNumber, int secondNumber, int productIndex) {
        boolean secondNumberFound = false;
        while (productIndex < input.size() && !secondNumberFound) {
            if (input.get(productIndex) == firstNumber * secondNumber) {
                secondNumberFound = true;
            } else {
                productIndex++;
            }
        }
        if (secondNumberFound) {
            return productIndex;
        } else {
            return -1;
        }
    }
}

