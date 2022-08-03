import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode no. 139
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into a space-separated sequence of one or more dictionary words
 * <p>
 * Ex1: s="leetcode" wordDict={"leet", "code"}
 * Output: true
 * <p>
 * Ex2: s="applepenapple" wordDict={apple, pen}
 * Output: true
 * <p>
 * Ex3: s="catsandog" wordDict={cats, sand, dog, and, cat}
 * Output: false
 */

public class WordBreak {

    // time complexity: O(n * length of max word in dictionary)
    public boolean wordbreak(String str, List<String> wordDict) {
        final int n = str.length();
        Set<String> dict = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[n+1];
        Arrays.fill(dp, false);

        //memoization structure , dp[i] - stores whether substring ending at pos.i is contained in dictionary
        dp[0] = true;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                //substring fct. starts from specified beginIndex till the character present at endIndex – 1
                //"leetcode" : substring(0,4)="leet"
                if (dp[j] && dict.contains(str.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        boolean result = wb.wordbreak("applepenapple", Arrays.asList("apple", "pen"));
        System.out.println(result);
        boolean res2 = wb.wordbreak("catsandog", Arrays.asList("cats", "sand", "dog", "and", "dogs"));
        System.out.println(res2);
    }
}
