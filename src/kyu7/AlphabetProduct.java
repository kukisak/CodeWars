package kyu7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlphabetProduct {
    /**
     * I have four positive integers, A, B, C and D, where A < B < C < D.
     * The input is a list of the integers A, B, C, D, AxB, BxC, CxD, DxA in some order.
     * Your task is to return the value of D.
     * Algorithm
     *     a) sort the numbers by size ASC
     *        => the order of input and results can be mixed so I have to look for the second number and the product number
     *     b) apply logic
     *       first input number is known
     *       iterate through array and find the second input number and computed product
     * @param input - list of numbers
     * @return value of the number D
     */
    public static int alphabet(int[] input) {
        List<Integer> listOfNumbers = Arrays.stream(input).sorted().boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        int A = listOfNumbers.remove(0);
        int B = findSecondInputNumber(listOfNumbers, A);
        int C = findSecondInputNumber(listOfNumbers, B);
        return findSecondInputNumber(listOfNumbers, C);
    }

    /**
     * Find the second input number of the product then remove the product and second number it-self.
     * Finally return the second number.
     * @param input - list of numbers (including product) without the first number
     * @param firstNumber - first number of product
     * @return second input number of the product
     */
    private static int findSecondInputNumber(List<Integer> input, int firstNumber) {
        int productIndex;
        int secondNumber = -1;
        for (int secondNumberIndex = 0; secondNumberIndex < input.size(); secondNumberIndex++) {
            productIndex = findProductIndex(input, firstNumber, (int) input.get(secondNumberIndex),
                    secondNumberIndex + 1);
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

    /**
     * For the given input list of number find index of the product for first and second number.
     * @param input - list of numbers
     * @param firstNumber - first number of the product (A x B - the A)
     * @param secondNumber - second number of the product (A x B - the B)
     * @param productIndex - initial value of the product index within input list
     * @return found index of the product or -1 if not found
     */
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

