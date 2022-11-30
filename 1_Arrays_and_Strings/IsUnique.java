// 1.1
// Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?

// There are 128 character alphabet.
// Create an array of length 128 contains boolean true/false
// to check whether you see that character in the string yet.

class isUnique {
    public static void main(String[] args) {
        System.out.println(isUniqueChars("hello"));
    }

    static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] char_set = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i); // returns the character at the specified index in a string
            System.out.println(value); // this value is a number (Unicode value of a character)
            if (char_set[value] == true) { // Already found this character in string
                return false;
            }
            char_set[value] = true;
        }
        return true;
    }
}

// Time Complexity: O(n)