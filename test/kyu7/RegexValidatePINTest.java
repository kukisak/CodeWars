package kyu7;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegexValidatePINTest {
    @Test
    public void validPins() {
        assertEquals(true, RegexValidatePIN.validatePin("1234"));
        assertEquals(true, RegexValidatePIN.validatePin("0000"));
        assertEquals(true, RegexValidatePIN.validatePin("1111"));
        assertEquals(true, RegexValidatePIN.validatePin("123456"));
        assertEquals(false, RegexValidatePIN.validatePin("12345689789"));
        assertEquals(true, RegexValidatePIN.validatePin("098765"));
        assertEquals(true, RegexValidatePIN.validatePin("000000"));
        assertEquals(true, RegexValidatePIN.validatePin("090909"));
    }

    @Test
    public void nonDigitCharacters() {
        assertEquals(false, RegexValidatePIN.validatePin("a234"));
        assertEquals(false, RegexValidatePIN.validatePin(".234"));
    }

    @Test
    public void invalidLengths() {
        assertEquals(false, RegexValidatePIN.validatePin("1"));
        assertEquals(false, RegexValidatePIN.validatePin("12"));
        assertEquals(false, RegexValidatePIN.validatePin("123"));
        assertEquals(false, RegexValidatePIN.validatePin("12345"));
        assertEquals(false, RegexValidatePIN.validatePin("1234567"));
        assertEquals(false, RegexValidatePIN.validatePin("-1234"));
        assertEquals(false, RegexValidatePIN.validatePin("1.234"));
        assertEquals(false, RegexValidatePIN.validatePin("00000000"));
    }
}