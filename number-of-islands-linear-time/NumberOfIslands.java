// https://leetcode.com/problems/number-of-islands
// LC200. Number of Islands
// Linear time, linear extra-space.
class NumberOfIslands {
    void exploreLand(int x, int y, char[][] grid, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        if (x < 0 || x >= n) { return; }
        if (y < 0 || y >= m) { return; }
        if (grid[x][y] == '0') { return; }
        
        if (visited[x][y]) { return; }
        visited[x][y] = true;

        exploreLand(x+1, y, grid, visited);
        exploreLand(x-1, y, grid, visited);
        exploreLand(x, y+1, grid, visited);
        exploreLand(x, y-1, grid, visited);
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count ++;
                    exploreLand(i, j, grid, visited);
                }
            }
        }
        return count;
    }
}
