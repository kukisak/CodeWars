package kyu6;

import kyu6.MultipliesOf3and5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultipliesOf3and5Test {
    @Test
    public void test() {
        assertEquals(23, new MultipliesOf3and5().solution(10));
    }


}