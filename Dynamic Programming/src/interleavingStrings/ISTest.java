package interleavingStrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ISTest {

    InterleavingStrings is = new InterleavingStrings();

    @Test
    public void containsAllLettersandPreservesOrder() {
        assertTrue(is.findSI("abd", "cef", "abcdef"));
    }

    @Test
    public void containsAllLettersDoesNotPreserveOrder(){
        assertFalse(is.findSI("abd", "cef", "adcbef"));
    }

    @Test
    public void doesNotContainAllLetters(){
        assertFalse(is.findSI("abc", "def", "abdccf"));
    }

    @Test
    public void containsAllLettersAndPreservesOrder2(){
        assertTrue(is.findSI("abcdef", "mnop", "mnaobcdepf"));
    }

}
