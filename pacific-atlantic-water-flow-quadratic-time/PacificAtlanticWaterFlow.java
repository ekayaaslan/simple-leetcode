// https://leetcode.com/problems/pacific-atlantic-water-flow/
// LC417. Pacific Atlantic Water Flow
// Quadratic time, linear extra-space.
class PacificAtlanticWaterFlow {
    boolean reachPacific(int x, int y, int[][] heights, int lastHeight, boolean[][] visited) {
        int n = heights.length;
        int m = heights[0].length;
        if (x < 0 || x == n) { return false; }        
        if (y < 0 || y == m) { return false; }
        if (heights[x][y] > lastHeight) { return false; }
        if (x == 0 || y == 0) { return true; }        
        if (visited[x][y]) { return false; }
        visited[x][y] = true;
        int height = heights[x][y];
        if (reachPacific(x-1, y, heights, height, visited)) { return true; }
        if (reachPacific(x+1, y, heights, height, visited)) { return true; }
        if (reachPacific(x, y-1, heights, height, visited)) { return true; }
        if (reachPacific(x, y+1, heights, height, visited)) { return true; }
        visited[x][y] = false;
        return false;
    }
    boolean reachAtlantic(int x, int y, int[][] heights, int lastHeight, boolean[][] visited) {
        int n = heights.length;
        int m = heights[0].length;
        if (x < 0 || x == n) { return false; }        
        if (y < 0 || y == m) { return false; }
        if (heights[x][y] > lastHeight) { return false; }
        if (x == n-1 || y == m-1) { return true; }        
        if (visited[x][y]) { return false; }
        visited[x][y] = true;
        int height = heights[x][y];
        if (reachAtlantic(x-1, y, heights, height, visited)) { return true; }
        if (reachAtlantic(x+1, y, heights, height, visited)) { return true; }
        if (reachAtlantic(x, y-1, heights, height, visited)) { return true; }
        if (reachAtlantic(x, y+1, heights, height, visited)) { return true; }
        visited[x][y] = false;
        return false;
    }
    boolean pacific(int x, int y, int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] visited = new boolean[n][m];
        return reachPacific(x, y, heights, Integer.MAX_VALUE, visited);
    }
    boolean atlantic(int x, int y, int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] visited = new boolean[n][m];
        return reachAtlantic(x, y, heights, Integer.MAX_VALUE, visited);
    }    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> out = new ArrayList();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (pacific(i, j, heights) && atlantic(i, j, heights)) {
                    out.add(List.of(i, j));
                }
            }
        }
        return out;
    }
}
