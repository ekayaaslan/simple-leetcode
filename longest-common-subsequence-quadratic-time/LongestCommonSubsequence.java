// https://leetcode.com/problems/longest-common-subsequence
// LC1143. Longest Common Subsequence
// Quadratic time, quadratic extra-space.
// 2D Dynamic programming
class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] longest = new int[n+1][m+1];
        for (int i=n-1; i>=0; i--) {
            for (int j=m-1; j>=0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    longest[i][j] = longest[i+1][j+1]+1;
                    continue;
                }
                longest[i][j] = Math.max(longest[i+1][j], longest[i][j+1]);
            }
        }
        return longest[0][0];
    }
}
