package kyu7;

import org.junit.Test;

import static org.junit.Assert.*;

public class DescendingOrderTest {

    @Test
    public void sortDesc() {
        assertEquals(54421, DescendingOrder.sortDesc(42145));
        assertEquals(654321, DescendingOrder.sortDesc(145263));
        assertEquals(987654321, DescendingOrder.sortDesc(123456789));
    }
    @Test
    public void sortDescBest() {
        assertEquals(54421, DescendingOrder.sortDescBest(42145));
        assertEquals(654321, DescendingOrder.sortDescBest(145263));
        assertEquals(987654321, DescendingOrder.sortDescBest(123456789));
    }
    @Test
    public void sortDescClever() {
        assertEquals(54421, DescendingOrder.sortDescClever(42145));
        assertEquals(654321, DescendingOrder.sortDescClever(145263));
        assertEquals(987654321, DescendingOrder.sortDescClever(123456789));
    }
}