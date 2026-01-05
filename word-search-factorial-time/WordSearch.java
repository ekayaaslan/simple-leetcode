// https://leetcode.com/problems/word-search
// LC79. Word Search
// Factorial time, linear extra-space.
class Solution {
    class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    boolean search(int x, int y, char[][] board, String word, boolean[][] seen) {
        if (word.isEmpty()) { 
            return true; 
        }
        int n = board.length;
        int m = board[0].length;
        if (x < 0 || x >= n) { return false; }
        if (y < 0 || y >= m) { return false; }
        if (board[x][y] != word.charAt(0)) { return false; }
        if (seen[x][y]) { return false; }
        seen[x][y] = true;
        if (search(x+1, y, board, word.substring(1), seen)) { return true; }
        if (search(x-1, y, board, word.substring(1), seen)) { return true; }
        if (search(x, y-1, board, word.substring(1), seen)) { return true; }
        if (search(x, y+1, board, word.substring(1), seen)) { return true; }
        seen[x][y] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] seen = new boolean[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (search(i, j, board, word, seen)) {
                    return true;
                }
            }
        }
        return false;
    }
}
