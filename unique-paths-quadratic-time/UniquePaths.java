// https://leetcode.com/problems/unique-paths
// LC62. Unique Paths
// Quadratic time, quadratic extra-space.
// 2D Dynamic programming, Combinatorics, Reduction.
class UniquePaths {
    int combination(int a, int b) {
        int[][] counts = new int[a+1][a+1];
        counts[0][0] = 1;
        for (int i=1; i<=a; i++) {
            counts[i][0] = 1;
            for (int j=1; j<i; j++) {
                counts[i][j] = 
                    counts[i-1][j] + counts[i-1][j-1];
            }
            counts[i][i] = 1;
        }
        return counts[a][b];
    }
    public int uniquePaths(int m, int n) {
        return combination(m+n-2, n-1);
    }
}
