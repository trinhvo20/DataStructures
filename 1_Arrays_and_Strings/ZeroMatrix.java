// Write an algorithm such that if an element in an MxN matrix is 0, 
// its entire row and column are set to 0.

class ZeroMatrix {
    public static void main(String[] args) {

    }

    static void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        // Store the row and col index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][i] == 0) {
                    row[i] = true;
                    col[i] = true;
                }
            }
        }

        // Nullify rows
        for (int i = 0; i < row.length; i++) {
            if (row[i])
                nullifyRow(matrix, i);

        }

        // Nullify columns
        for (int i = 0; i < col.length; i++) {
            if (col[i])
                nullifyColumn(matrix, i);

        }
    }

    static void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    static void nullifyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
