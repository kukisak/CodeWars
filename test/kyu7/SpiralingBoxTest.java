package kyu7;


import org.junit.Test;

import static org.junit.Assert.*;

public class SpiralingBoxTest {
    @Test
    public void sampleTests()
    {
        final int[][] box_7_8 = {{1, 1, 1, 1, 1, 1, 1},
                {1, 2, 2, 2, 2, 2, 1},
                {1, 2, 3, 3, 3, 2, 1},
                {1, 2, 3, 4, 3, 2, 1},
                {1, 2, 3, 4, 3, 2, 1},
                {1, 2, 3, 3, 3, 2, 1},
                {1, 2, 2, 2, 2, 2, 1},
                {1, 1, 1, 1, 1, 1, 1}};

        final int[][] box_8_7 = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 3, 3, 3, 3, 2, 1},
                {1, 2, 3, 4, 4, 3, 2, 1},
                {1, 2, 3, 3, 3, 3, 2, 1},
                {1, 2, 2, 2, 2, 2, 2, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}};

        final int[][] box_4_2 = {{1, 1, 1, 1}, {1, 1, 1, 1}};

        final int[][] box_2_4 = {{1, 1}, {1, 1}, {1, 1}, {1, 1}};

        assertArrayEquals(box_7_8, SpiralingBox.createBox(7,8));

        assertArrayEquals(box_8_7, SpiralingBox.createBox(8,7));

        assertArrayEquals(box_4_2, SpiralingBox.createBox(4,2));

        assertArrayEquals(box_2_4, SpiralingBox.createBox(2,4));
    }
}