// Given 2 strings, write a method to decide if one is permutation of the other.
// Ex: 'god' = 'dog'

public class CheckPermutation {
    public static void main(String[] args) {
        System.out.println(isPermutation("dog", "god"));
    }

    // first, sort the string
    static String sort(String s) {
        char[] charArr = s.toCharArray();
        java.util.Arrays.sort(charArr);
        String sortedStr = new String(charArr);
        return sortedStr;
    }

    // compare sorted strings
    static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return sort(s1).equals(sort(s2));
    }
}
