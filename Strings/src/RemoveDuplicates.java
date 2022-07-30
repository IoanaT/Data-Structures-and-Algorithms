class RemoveDuplicates {
    // returns the remaining string without iterated characters
    static String removeDuplicates(char[] str) {
        // return if string is null or length is equal to zero
        if (str == null || str.length == 0 || str[0] == '\0') {
            return "";
        }

        // Creates a hashet
        Set<Character> hashset = new LinkedHashSet<Character>();

        int writeIndex = 0;
        int readIndex = 0;

        // Iterates loop till end of strinng
        while (readIndex != str.length) {
            // Add current character in hashset if its not in set before
            if (!hashset.contains(str[readIndex])) {
                hashset.add(str[readIndex]);

                // copy character at the readIndex location to the writeIndex location within the string
                str[writeIndex] = str[readIndex];
                writeIndex++;
            }
            readIndex++;
        }

        // Returns string without duplicates
        String ansStr = String.valueOf(Arrays.copyOfRange(str, 0, writeIndex));
        return ansStr;
    }

    public static void main(String[] args) {
        String str = "dabbac";
        System.out.println("1.     Before: " + str);
        char[] charStr = str.toCharArray();
        System.out.println("       After:  " + removeDuplicates(charStr));
        System.out.println(
                "\n-----------------------------------------------------------------------------------------------------\n");
        String str1 = "aabbbccdddeee";
        System.out.println("2.     Before: " + str1);
        charStr = str1.toCharArray();
        System.out.println("       After:  " + removeDuplicates(charStr));
        System.out.println(
                "\n-----------------------------------------------------------------------------------------------------\n");
        String str2 = "abcdef";
        System.out.println("3.     Before: " + str2);
        charStr = str2.toCharArray();
        System.out.println("       After:  " + removeDuplicates(charStr));
        System.out.println(
                "\n-----------------------------------------------------------------------------------------------------\n");
    }
}