/**
 * Given a string, we want to cut it into pieces such that each piece is a palindrome.
 * Write a function to return the minimum number of cuts needed.
 * <p>
 * Ex1. Input: "abdbca"
 * Output: 3
 * Explanation: Palindrome pieces are "a", "bdb", "c", "a".
 * <p>
 * Ex2. Input: = "cddpd"
 * Output: 2
 * Explanation: Palindrome pieces are "c", "d", "dpd".
 */
public class PalindromePartitioning {

    public int findMinCuts(String st) {
        Integer[][] dp = new Integer[st.length()][st.length()];
        Boolean dpIsPalindrome[][] = new Boolean[st.length()][st.length()];

        return this.findMinCutsRecursive(dp, dpIsPalindrome, st, 0, st.length() - 1);
    }

    private int findMinCutsRecursive(Integer[][] dp, Boolean[][] dpIsPalindrome, String st,
                                     int start, int end) {
        if (start >= end || isPalindrome(dpIsPalindrome, st, 0, st.length() - 1))
            return 0;

        if (dp[start][end] == null) {
            //max no of cuts for string
            int minCuts = end - start;
            for (int i = start; i <= end; i++) {
                if (isPalindrome(dpIsPalindrome, st, start, i)) {
                    //we can cut here as we have a palindrom from 'start' to 'i'
                    minCuts = Math.min(minCuts, 1 + findMinCutsRecursive(dp, dpIsPalindrome, st, i + 1, end));
                }
            }
            dp[start][end] = minCuts;
        }
        return dp[start][end];
    }

    private boolean isPalindrome(Boolean[][] dpIsPalindrome, String st, int x, int y) {
        if (dpIsPalindrome[x][y] == null) {
            dpIsPalindrome[x][y] = true;
            int i = x;
            int j = y;
            while (i < j) {
                if (st.charAt(i++) != st.charAt(j--)) {
                    dpIsPalindrome[x][y] = false;
                    break;
                }
                if (i < j && dpIsPalindrome[i][j] != null) {
                    dpIsPalindrome[x][y] = dpIsPalindrome[i][j];
                    break;
                }
            }

        }
        return dpIsPalindrome[x][y];
    }

    public static void main(String[] args) {
        PalindromePartitioning mpp = new PalindromePartitioning();
        System.out.println(mpp.findMinCuts("abdbca"));
        System.out.println(mpp.findMinCuts("cdpdd"));
        System.out.println(mpp.findMinCuts("pqr"));
        System.out.println(mpp.findMinCuts("pp"));
    }
}
