// Importing required functions
import java.util.*;

class PalindromeSubStrings {
    // This function finds if the substring from index [start to last] is palindrome or not
    public static boolean isPalindrome(String input, int start, int last) {
        while (last > start) {
            if (input.charAt(start) != input.charAt(last))
                return false;
            start++;
            last--;
        }
        return true;
    }

    // This function receives input string and returns the palindromes list
    public static List<String> findAllPalindromeSubstrings(String input) {
        List<String> palindrome = new ArrayList<String>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                // storing the palindromes in palindromes array
                if (isPalindrome(input, i, j)) {
                    palindrome.add(input.substring(i, j+1));
                }
            }
        }

        return palindrome;
    }

    public static void main(String[] args) {
        String[] inputStr = {"aabbbaa", "321230990", "educative"};
        for (int i = 0; i < inputStr.length; i++) {
            List<String> result = findAllPalindromeSubstrings(inputStr[i]);
            System.out.println((i + 1) + ".   Input string: " + inputStr[i]);
            System.out.println("     Palindromes: " + result.toString());
            System.out.println("     Total palindrome substrings: " + result.size());
            System.out.println(
                    "----------------------------------------------------------------------------------------------------\n");
        }
    }
}
