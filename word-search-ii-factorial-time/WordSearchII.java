// https://leetcode.com/problems/word-search-ii
// LC212. Word Search II
// Factorial time, linear extra-space.
class WordSearchII {
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
    boolean exists(char[][] board, String word) {
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
    public List<String> findWords(char[][] board, String[] words) {
        List<String> out = new ArrayList();
        for (String word : words) {
            if (exists(board, word)) {
                out.add(word);
            }
        }
        return out;
    }    
}
