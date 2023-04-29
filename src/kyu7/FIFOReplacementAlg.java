package kyu7;

import java.util.Collections;
import java.util.Vector;

public class FIFOReplacementAlg {
    public static int[] fifo(int n, int[] referenceList) {
        /*
        N = 3,
        REFERENCE LIST = [1, 2, 3, 4, 2, 5],
          * 1 is read, page fault --> memory = [1];
          * 2 is read, page fault --> memory = [1, 2];
          * 3 is read, page fault --> memory = [1, 2, 3];
          * 4 is read, page fault --> memory = [4, 2, 3];
          * 2 is read, already in memory, nothing happens;
          * 5 is read, page fault --> memory = [4, 5, 3].
         */
        Vector<Integer> data = new Vector<>(Collections.nCopies(n, -1));
        int headIndex = 0;
        for (Integer reference: referenceList) {
            if (!data.contains(reference)) {
                data.set(headIndex++, reference);
                headIndex %= n;
            }
        }
        return data.stream().mapToInt(i -> i).toArray();
    }
}
