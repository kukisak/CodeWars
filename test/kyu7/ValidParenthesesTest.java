package kyu7;

import org.junit.Test;

import static kyu7.ValidParentheses.*;
import static org.junit.Assert.*;

public class ValidParenthesesTest {

    @Test
    public void validParenthesesTest() {
        assertTrue(validParentheses("()"));
        assertFalse(validParentheses(")(()))"));
        assertFalse(validParentheses("("));
        assertFalse(validParentheses(")("));
        assertTrue(validParentheses("(())((()())())"));
    }
    @Test
    public void validParenthesesTestBest() {
        assertTrue(validParenthesesBest("()"));
        assertFalse(validParenthesesBest(")(()))"));
        assertFalse(validParenthesesBest("("));
        assertFalse(validParenthesesBest(")("));
        assertTrue(validParenthesesBest("(())((()())())"));
    }
    @Test
    public void validParenthesesTestClever() {
        assertTrue(validParenthesesClever("()"));
        assertFalse(validParenthesesClever(")(()))"));
        assertFalse(validParenthesesClever("("));
        assertFalse(validParenthesesClever(")("));
        assertTrue(validParenthesesClever("(())((()())())"));
    }
}