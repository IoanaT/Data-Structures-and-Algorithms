package palindromic.substrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PalindromicSubstrTest {

    PalindromicSubstr ps = new PalindromicSubstr();

    @Test
    public void test1(){
        int result = ps.findAllPalindromes("abc");
        assertEquals(result, 3);
    }

    @Test
    public void test2(){
        assertEquals(ps.findAllPalindromes("aaa"), 6);
    }
}
