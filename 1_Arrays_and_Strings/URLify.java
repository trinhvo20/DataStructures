// 1.3
// Write a method to replcae all spaces in a string with "%20"
// You may assume that the string has sufficient space at the end to hold the additional characters,
// and that you are given the "true" length of the string.

// Input:  "Mr John Smith    ", 13
// Output: "Mr%20John%20Smith"

// First, we count the number of spaces.
// We need extra 2 characters for each space (since '%20' is 2 characters longer than ' '), so we double this count.
// Then, we walk backwards through the string and editing it.
// When we see a space, we replace it with %20. If there is no space, we copy the original character.

// We use character array to perform the replace operation in place.

class URLify {
    public static void main(String[] args) {
        char[] charArr = "Mr John Smith    ".toCharArray();
        replaceSpaces(charArr, 13);
        System.out.println(charArr);
    }

    static void replaceSpaces(char[] str, int trueLength) {
        int numberOfSpaces = countOfChar(str, 0, trueLength, ' ');
        int newIndex = trueLength - 1 + numberOfSpaces * 2;

        // If there are excess spaces, add a null character.
        // This indicates that the spaces after that point have not been replaced with
        // %20.
        if (newIndex + 1 < str.length)
            str[newIndex + 1] = '\0';

        for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex--) {
            if (str[oldIndex] == ' ') {
                str[newIndex] = '0';
                str[newIndex - 1] = '2';
                str[newIndex - 2] = '%';
                newIndex -= 3;
            } else {
                str[newIndex] = str[oldIndex];
                newIndex--;
            }
        }
    }

    // Function to count number of spaces
    static int countOfChar(char[] str, int start, int end, int target) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (str[i] == target) {
                count++;
            }
        }
        return count;
    }
}
