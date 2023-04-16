package kyu7;

import org.junit.Test;

import static org.junit.Assert.*;

public class GrowthPopulationTest {

    @Test
    public void nbYear() {
        assertEquals(15, GrowthPopulation.nbYear(1500, 5, 100, 5000));
        assertEquals(10, GrowthPopulation.nbYear(1500000, 2.5, 10000, 2000000));
        assertEquals(1, GrowthPopulation.nbYear(1500, 0.0, 10000, 2000));
        assertEquals(Integer.MAX_VALUE, GrowthPopulation.nbYear(1500, 0.0, 0, 2000));
    }
}