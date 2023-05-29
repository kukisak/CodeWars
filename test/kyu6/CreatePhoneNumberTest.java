package kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatePhoneNumberTest {
    @Test
    public void tests() {
        assertEquals("(123) 456-7890", CreatePhoneNumber.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
    @Test
    public void testsClever() {
        assertEquals("(123) 456-7890", CreatePhoneNumber.createPhoneNumberClever(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}