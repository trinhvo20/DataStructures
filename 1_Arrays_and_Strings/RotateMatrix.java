// Given a image represented by an NxN matrix, where each pixel in the image is represented by an integer.
// Write a method to rotate the image by 90 degrees.
// Save top, move left to top, move bottom to left, move right to bottom, put top at right

class RotateMatrix {
    public static void main(String[] args) {

    }

    static boolean rotate(int[][] matrix) {
        // If matrix is not a square matrix, return false
        if (matrix.length == 0 || matrix.length != matrix[0].length)
            return false;

        int n = matrix.length;

        for (int layer = 0; layer < n; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                // Save top
                int top = matrix[first][i];
                // Left -> Top
                matrix[first][i] = matrix[last - offset][first];
                // Bottom -> Left
                matrix[last - offset][first] = matrix[last][last - offset];
                // Right -> Bottom
                matrix[last][last - offset] = matrix[i][last];
                // Top -> Right
                matrix[i][last] = top;
            }
        }
        return true;
    }
}

// O(N^2)