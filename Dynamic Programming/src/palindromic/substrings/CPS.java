package palindromic.substrings;

/**
 * Count of Palindromic Substrings
 */
public class CPS {
    public int findCPS(String st) {
        // dp[i][j] will be 'true' if the string from index 'i' to index 'j' is a
        // palindrome
        boolean[][] dp = new boolean[st.length()][st.length()];
        int count = 0;

        // every string with one character is a palindrome
        for (int i = 0; i < st.length(); i++) {
            dp[i][i] = true;
            count++;
        }

        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    // if it's a two character string or if the remaining string is a palindrome too
                    if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
                        dp[startIndex][endIndex] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CPS cps = new CPS();
        System.out.println(cps.findCPS("abdbca"));
        System.out.println(cps.findCPS("aaa"));
        System.out.println(cps.findCPS("cdpdd"));
        System.out.println(cps.findCPS("pqr"));
    }
}
