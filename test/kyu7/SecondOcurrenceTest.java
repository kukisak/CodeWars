package kyu7;

import org.junit.Test;

import static kyu7.SecondOcurrence.secondSymbol;
import static kyu7.SecondOcurrence.secondSymbolClever;
import static org.junit.Assert.*;

public class SecondOcurrenceTest {

    @Test
    public void secondSymbolTest() {
        assertEquals(3, secondSymbol("Hello world!!!",'l'));
        assertEquals(-1, secondSymbol("Hello world!!!",'A'));
        assertEquals(-1, secondSymbol("Hello world!!!",'d'));
        assertEquals(-1, secondSymbol("Hello world!!!y",'y'));
    }
    @Test
    public void secondSymbolTestClever() {
        assertEquals(3, secondSymbolClever("Hello world!!!",'l'));
        assertEquals(-1, secondSymbolClever("Hello world!!!",'A'));
        assertEquals(-1, secondSymbolClever("Hello world!!!",'d'));
        assertEquals(-1, secondSymbolClever("Hello world!!!y",'y'));
    }
}