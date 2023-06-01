package kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersistentBuggerTest {
    @Test
    public void basicTests() {
        assertEquals(3, PersistentBugger.persistence( 39), "Incorrect answer for n=39" );
        assertEquals(0, PersistentBugger.persistence(  4), "Incorrect answer for n=4"  );
        assertEquals(2, PersistentBugger.persistence( 25), "Incorrect answer for n=25" );
        assertEquals(4, PersistentBugger.persistence(999), "Incorrect answer for n=999");
    }

}