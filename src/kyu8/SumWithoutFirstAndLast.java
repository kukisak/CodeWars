package kyu8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumWithoutFirstAndLast {
    public static int sum(int[] numbers)
    {
        if (numbers == null) {
            return 0;
        }
        List<Integer> intList = new ArrayList<>(Arrays.stream(numbers).sorted().boxed().toList());
        if (intList.size() > 0) {
            intList.remove(intList.size() - 1);
        }
        if (intList.size() > 0) {
            intList.remove(0);
        }
        return intList.stream().reduce(Integer::sum).orElse(0);
    }

    public int sumBest(int[] numbers) {
        if (numbers == null || numbers.length < 2){
            return 0;
        }
        Arrays.sort(numbers);
        return Arrays.stream(numbers).skip(1L).limit(numbers.length-2).sum();
    }
}
