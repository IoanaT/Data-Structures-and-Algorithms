package palindromic.substrings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * LEETCODE NO. 647
 *
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even
 * if they consist of same characters.
 *
 * Example 1: Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2: Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * Note: The input string length won't exceed 1000.
 */
public class PalindromicSubstr {

    public int findAllPalindromes(String st) {
        Boolean[][] dpIsPalindrome = new Boolean[st.length()][st.length()];

        return this.findAllPalindromeRecursive(st, 0, st.length() - 1, dpIsPalindrome);
    }

    private int findAllPalindromeRecursive(String st, int start, int end, Boolean[][] dpIsPalindrome) {

        int count = 0;

        //if word is a palindrome
        if (isPalindrome(dpIsPalindrome, st, 0, st.length() - 1))
           count++;

        //look for palindromes in substrings
        for (int i = start; i <= end; i++) {
            if (isPalindrome(dpIsPalindrome, st, start, i)) {
                count +=  1 + findAllPalindromeRecursive(st, i + 1, end,  dpIsPalindrome);
            }
        }

        return count;
    }

    private boolean isPalindrome(Boolean[][] dpIsPalindrome, String st, int x, int y) {
        if (dpIsPalindrome[x][y] == null){
            dpIsPalindrome[x][y] = true;
            int i = x; int j = y;

            while(i < j){
                if (st.charAt(i++) != st.charAt(j--)){
                    dpIsPalindrome[x][y] = false;
                    break;
                }

                if (dpIsPalindrome[i][j] != null){
                    dpIsPalindrome[x][y] = dpIsPalindrome[i][j];
                    break;
                }
            }
        }
        return dpIsPalindrome[x][y];
    }

    public static void main(String[] args){
        PalindromicSubstr ps = new PalindromicSubstr();
        System.out.println(ps.findAllPalindromes("abc"));
        System.out.println(ps.findAllPalindromes("aaa"));
    }
}
