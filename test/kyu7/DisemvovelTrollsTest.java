package kyu7;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DisemvovelTrollsTest {
    @Test
    public void FixedTests() {
        assertEquals("Ths wbst s fr lsrs LL!",DisemvovelTrolls.disemvowel("This website is for losers LOL!")
        );
        assertEquals("N ffns bt,\nYr wrtng s mng th wrst 'v vr rd", DisemvovelTrolls.disemvowel(
                "No offense but,\nYour writing is among the worst I've ever read"));
        assertEquals( "Wht r y,  cmmnst?", DisemvovelTrolls.disemvowel("What are you, a communist?"));
    }
}