// Write a method to perform basic compression using the counts of repeated characters.
// EX: aabcccccaaa would become a2b1c5a3
// If the compressed string is longer than the original string, return the original string
// You can assume string only contains letters.

// We use StringBuilder to save runtime, since string concatenation operation in O(n^2) time
class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }

    static String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // If the next character is different than the current, append this char to
            // result
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressed.length() > str.length() ? str : compressed.toString();
    }
}
