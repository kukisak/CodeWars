package kyu8;

import org.junit.Test;

import static kyu8.InvertValues.invert;
import static kyu8.InvertValues.invertBest;
import static org.junit.Assert.*;

public class InvertValuesTest {

    @Test
    public void invertTest() {
        assertArrayEquals(new int[]{-1,-2,-3,-4,-5}, invert(new int[]{1,2,3,4,5}));
        assertArrayEquals(new int[]{-1,2,-3,4,-5}, invert(new int[]{1,-2,3,-4,5}));
        assertArrayEquals(new int[]{}, invert(new int[]{}));
    }
    @Test
    public void invertTestBest() {
        assertArrayEquals(new int[]{-1,-2,-3,-4,-5}, invertBest(new int[]{1,2,3,4,5}));
        assertArrayEquals(new int[]{-1,2,-3,4,-5}, invertBest(new int[]{1,-2,3,-4,5}));
        assertArrayEquals(new int[]{}, invertBest(new int[]{}));
    }
}