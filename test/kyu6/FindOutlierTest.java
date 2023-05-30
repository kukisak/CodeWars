package kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindOutlierTest {
    @Test
    public void testExample() {
        int[] exampleTest1 = {2,6,8,-10,3};
        int[] exampleTest2 = {206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781};
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
        int[] exampleTest4 = {0, 0, 0, 1};
        int[] exampleTest5 = {-2, -4, -6, -3};
        assertEquals(3, FindOutlier.find(exampleTest1));
        assertEquals(206847684, FindOutlier.find(exampleTest2));
        assertEquals(0, FindOutlier.find(exampleTest3));
        assertEquals(1, FindOutlier.find(exampleTest4));
        assertEquals(-3, FindOutlier.find(exampleTest5));
    }
    @Test
    public void testExampleClever() {
        int[] exampleTest1 = {2,6,8,-10,3};
        int[] exampleTest2 = {206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781};
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
        int[] exampleTest4 = {0, 0, 0, 1};
        int[] exampleTest5 = {-2, -4, -6, -3};
        assertEquals(3, FindOutlier.findClever(exampleTest1));
        assertEquals(206847684, FindOutlier.findClever(exampleTest2));
        assertEquals(0, FindOutlier.findClever(exampleTest3));
        assertEquals(1, FindOutlier.findClever(exampleTest4));
        assertEquals(-3, FindOutlier.findClever(exampleTest5));
    }

}