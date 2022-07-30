// Importing required functions
import java.util.*;

class ReverseWords {
    // Null terminating strings are not used in java
    public static void strRev(char[] str, int start, int end) {
        // return if string is null or length of string is less than 2
        if (str == null || str.length < 1) {
            return;
        }

        // Swap characters, starting from the two extremes
        // and moving in towards the centre of the string
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }

    public static String reverseWords(char[] sentence) {
        // Here sentence is a null-terminated string ending with char '\0'?
        if (sentence == null || sentence.length == 0) {
            return "String is empty";
        }

        // To reverse all words in the string, we will first reverse
        // the string. Now all the words are in the desired location, but
        // in reverse order: "Hello World" -> "dlroW olleH".
        int strLen = sentence.length;
        strRev(sentence, 0, strLen - 1);

        // Now, let's iterate the sentence and reverse each word in place.
        // "dlroW olleH" -> "World Hello"
        int start = 0;
        int end = 0;

        while (true) {
            if (start >= strLen - 1) {
                break;
            }

            // find the start index of a word while skipping spaces.
            while (sentence[start] == ' ') {
                start++;
            }

            // find the end index of the word.
            end = start + 1;
            while (end < strLen && sentence[end] != ' ') {
                end++;
            }

            // let's reverse the word in-place.
            strRev(sentence, start, end - 1);
            start = end;
        }

        return String.valueOf(sentence);
    }

    public static void main(String[] args) {
        String stringToReverse1 = "Hello World!";
        System.out.println("1.    Actual string:   " + stringToReverse1);
        char[] stringChar = stringToReverse1.toCharArray();

        System.out.println("      Reversed string: " + reverseWords(stringChar));
        System.out.println(
                "\n-----------------------------------------------------------------------------------------------------\n");
        String stringToReverse2 = "The quick brown fox jumped over the lazy dog.";
        System.out.println("2.    Actual string:   " + stringToReverse2);
        stringChar = stringToReverse2.toCharArray();

        System.out.println("      Reversed string: " + reverseWords(stringChar));
        System.out.println(
                "\n-----------------------------------------------------------------------------------------------------\n");
    }
}
