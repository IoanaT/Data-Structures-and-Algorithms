package interleaving.strings;

import java.util.HashMap;
import java.util.Map;

/** LEETCODE NO. 97
 * Given three strings ‘m’, ‘n’, and ‘p’, write a method to find out if ‘p’ has been formed by interleaving ‘m’ and ‘n’.
 * ‘p’ would be considered interleaving ‘m’ and ‘n’ if it contains all the letters from ‘m’ and ‘n’ and the order of
 * letters is preserved too.
 *
 * Example 1:
 =============
 * Input: m="abd", n="cef", p="abcdef"
 * Output: true
 * Explanation: 'p' contains all the letters from 'm' and 'n' and preserves their order too.
 *
 * Example 2:
 =============
 * Input: m="abd", n="cef", p="adcbef"
 * Output: false
 * Explanation: 'p' contains all the letters from 'm' and 'n' but does not preserve the order.
 *
 * Example 3:
 =============
 * Input: m="abc", n="def", p="abdccf"
 * Output: false
 * Explanation: 'p' does not contain all the letters from 'm' and 'n'.
 *
 * Example 4:
 ==============
 * Input: m="abcdef", n="mnop", p="mnaobcdepf"
 * Output: true
 * Explanation: 'p' contains all the letters from 'm' and 'n' and preserves their order too.
 */
public class InterleavingStrings {

    public Boolean findSI(String m, String n, String p) {
        Map<String, Boolean> dp = new HashMap<>();
        return findSIRecursive(dp, m, n, p, 0, 0, 0);
    }

    private boolean findSIRecursive(Map<String, Boolean> dp, String m, String n, String p,
                                    int mIndex, int nIndex, int pIndex) {

        // if we have reached the end of the all the strings
        if(mIndex == m.length() && nIndex == n.length() && pIndex == p.length())
            return true;

        // if we have reached the end of 'p' but 'm' or 'n' still has some characters left
        if(pIndex == p.length())
            return false;

        String subProblemKey = mIndex + "-" + nIndex + "-" + pIndex;
        if(!dp.containsKey(subProblemKey)) {
            boolean b1=false, b2=false;
            if(mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex))
                b1 = findSIRecursive(dp, m, n, p, mIndex+1, nIndex, pIndex+1);

            if(nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex))
                b2 = findSIRecursive(dp, m, n, p, mIndex, nIndex+1, pIndex+1);

            dp.put(subProblemKey, b1 || b2);
        }

        return dp.get(subProblemKey);
    }

    public static void main(String[] args) {
        InterleavingStrings is = new InterleavingStrings();
        System.out.println(is.findSI("abd", "cef", "abcdef"));
        System.out.println(is.findSI("abd", "cef", "adcbef"));
        System.out.println(is.findSI("abc", "def", "abdccf"));
        System.out.println(is.findSI("abcdef", "mnop", "mnaobcdepf"));
    }
}

