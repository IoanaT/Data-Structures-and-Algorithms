/**
 * Given a string, find the length of its Longest Palindromic Substring (LPS)
 * Ex1. Input: "abdbca"
 * Output: 3
 * Explanation: LPS is "bdb".
 *
 * Ex2. Input: = "pqr"
 * Output: 1
 * Explanation: LPS could be "p", "q" or "r".
 *
 * Ex3. Input: = "cddpd"
 * Output: 3
 * Explanation: LPS is "dpd".
 */
public class LongestPalindromicSubstr {

    public int findLPSLength(String st) {
        Integer[][] dp = new Integer[st.length()][st.length()];
        return findLPSLengthRecursive(dp, st, 0, st.length() - 1);
    }

    private int findLPSLengthRecursive(Integer[][] dp, String st, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        // every string with one character is a palindrome
        if (startIndex == endIndex)
            return 1;

        if (dp[startIndex][endIndex] == null) {
            // case 1: elements at the beginning and the end are the same
            if (st.charAt(startIndex) == st.charAt(endIndex)) {
                int remainingLength = endIndex - startIndex - 1;
                // check if the remaining string is also a palindrome
                if (remainingLength == findLPSLengthRecursive(dp, st, startIndex + 1, endIndex - 1)) {
                    dp[startIndex][endIndex] = remainingLength + 2;
                    return dp[startIndex][endIndex];
                }
            }

            // case 2: skip one character either from the beginning or the end
            int c1 = findLPSLengthRecursive(dp, st, startIndex + 1, endIndex);
            int c2 = findLPSLengthRecursive(dp, st, startIndex, endIndex - 1);
            dp[startIndex][endIndex] = Math.max(c1, c2);
        }

        return dp[startIndex][endIndex];
    }

    public static void main(String[] args) {
        LongestPalindromicSubstr lps = new LongestPalindromicSubstr();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
    }
}
