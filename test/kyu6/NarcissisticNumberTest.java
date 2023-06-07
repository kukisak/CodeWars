package kyu6;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NarcissisticNumberTest {
    @Test
    public void exampleTests() {
        assertTrue(NarcissisticNumber.isNarcissistic(153), "153 is narcissistic");
        assertTrue(NarcissisticNumber.isNarcissistic(1634), "1634 is narcissistic");
        assertFalse(NarcissisticNumber.isNarcissistic(112), "112 is not narcissistic");
    }
    @Test
    public void exampleTestsClever() {
        assertTrue(NarcissisticNumber.isNarcissisticClever(153), "153 is narcissistic");
        assertTrue(NarcissisticNumber.isNarcissisticClever(1634), "1634 is narcissistic");
        assertFalse(NarcissisticNumber.isNarcissisticClever(112), "112 is not narcissistic");
    }

}