// 1.4
// Given a string, write a function to check if it is a permutation of a palindrome.
// A palindrome is a word or phase that is the same forwards and backwards.

// Input : Tact Coa
// Output: True (permutation: "taco cat, " atco cta", etc.)

// To check if a string is a permutation of a palindrome, that string must have even number of almost all characters,
// and at most 1 character can have an odd count.
// A string with even length must have even counts of all characters.
// A string with odd length must have exactly 1 character with an odd count.
// For ex, tactcoapapa is a permutation of a palindrome because it has 2 Ts, 4 As, 2 Cs, 2 Ps, and 1 O.

// We will use a hash table to count how many times each character appears.
// Then we iterate through the hash table and ensure that no more than 1 character has an odd count.

class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("Tact Coa"));
    }

    static boolean isPermutationOfPalindrome(String str) {
        int[] table = buildCharFrequencyTable(str);
        return checkMaxOneOdd(table);
    }

    // Count how many times each character appears.
    static int[] buildCharFrequencyTable(String str) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c : str.toCharArray()) {
            int x = getCharNumber(c); // x is index of a character
            if (x != -1) { // if x is not a non-letter character, count it
                table[x]++;
            }
        }
        return table;
    }

    // Map each character to a number : a->0, b->1, c->2, ....
    // Non-letter characters map to -1.
    static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    // Check that no more than 1 character has an odd count
    static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;

        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }
}

// Take O(N) time, where N is the length of the string