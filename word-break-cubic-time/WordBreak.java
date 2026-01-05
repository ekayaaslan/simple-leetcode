// https://leetcode.com/problems/word-break
// LC139. Word Break
// Cubic time, linear extra-space.
class WordBreak {
    boolean isInDict(String s, List<String> wordDict) {
        for (String word : wordDict) {
            if (s.equals(word)) {
                return true;
            }
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] segmented = new boolean[n+1];
        segmented[n] = true;
        for (int i=n-1; i>=0; i--) {
            for (int j=i+1; j<=n; j++) {
                String sub = s.substring(i, j);
                if (segmented[j] && isInDict(sub, wordDict)) {
                    segmented[i] = true;
                }
            }
        }
        return segmented[0];
    }
}