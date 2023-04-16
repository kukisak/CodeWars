package kyu7;

import org.junit.Test;

import static kyu7.HighestAndLowest.*;
import static org.junit.Assert.*;

public class HighestAndLowestTest {

    @Test
    public void test1(){
        assertEquals("5 1", highAndLow("1 2 3 4 5"));
        assertEquals("5 -3", highAndLow("1 2 -3 4 5"));
        assertEquals("9 -5", highAndLow("1 9 3 4 -5"));
        assertEquals("3 3", highAndLow("3"));
    }

    @Test
    public void test1Best(){
        assertEquals("5 1", highAndLowBest("1 2 3 4 5"));
        assertEquals("5 -3", highAndLowBest("1 2 -3 4 5"));
        assertEquals("9 -5", highAndLowBest("1 9 3 4 -5"));
        assertEquals("3 3", highAndLowBest("3"));
    }
    @Test
    public void test1Clever(){
        assertEquals("5 1", highAndLowClever("1 2 3 4 5"));
        assertEquals("5 -3", highAndLowClever("1 2 -3 4 5"));
        assertEquals("9 -5", highAndLowClever("1 9 3 4 -5"));
        assertEquals("3 3", highAndLowClever("3"));
    }

}