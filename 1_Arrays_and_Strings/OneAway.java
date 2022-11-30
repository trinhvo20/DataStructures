import javax.swing.text.StyledEditorKit.BoldAction;

// Operation on strings: insert a character, remove a character, or replace a character.
// Given 2 strings write a function to check if they are one edit (or zero edit) away.

// pale, ple -> true
// pales, pale -> true
// pale, bale -> true
// pale, bae -> false

// We will check replacement in 1 step, and check insertion and remmoval in another step.
// The length of the string will tell us which one we need to check.

class OneAway {
    public static void main(String[] args) {

    }

    static boolean OneEditAway(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return oneEditReplace(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return oneEditInsert(s1, s2);
        } else if (s1.length() == s2.length() + 1) {
            return oneEditInsert(s2, s1);
        }
        return false;
    }

    private static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    // Check if you can insert a character into s1 to make s2s
    private static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;

        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

}
