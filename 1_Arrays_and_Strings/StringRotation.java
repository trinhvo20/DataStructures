// 1.9
// Assume you have a method isSubstring which checks if one word is a substring
// of another. Given two strings, s1 and s2, write code to check if s2 is a 
// rotation of s1 using only one call to isSubstring 
// (e.g.,"waterbottle" is a rotation of "erbottlewat").

class StringRotation {
    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }

    static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length() || s1.length() == 0) {
            return false;
        }

        // First, we need to find the rotation point
        // Ex: s1 = xy = waterbottle
        // x = wat
        // y = erbottle
        // s2 = yx = erbottlewat
        // No matter where the split point is, yx (s2) is always a substring of xyxy
        // (s1s1)
        String s1s1 = s1 + s1;
        return isSubstring(s1s1, s2);
    }

    // Function to determine if s2 is a substring of s1
    static boolean isSubstring(String s1, String s2) {
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(count)) {
                count++;
            } else {
                count = 0;
            }
            if (count == s2.length()) {
                return true;
            }
        }

        return false;
    }
}
