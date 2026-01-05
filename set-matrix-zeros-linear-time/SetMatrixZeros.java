// https://leetcode.com/problems/set-matrix-zeroes
// LC73. Set Matrix Zeros
// Linear time, sublinear extra-space.
class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] rowIsZero = new boolean[n];
        boolean[] colIsZero = new boolean[m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j] == 0) {
                    rowIsZero[i] = true;
                    colIsZero[j] = true;
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (rowIsZero[i] || colIsZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}