// https://leetcode.com/problems/longest-repeating-character-replacement
// LC424. Longest Repeating Character Replacement
// Quadratic time, constant extra-space.
class LongestRepeatingCharacterReplacement {
    int findRun(String s, int k, char ch) {
        int n = s.length();
        int change = 0;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == ch) { continue; }
            if (change == k) {
                return i;
            }
            change ++;
        }
        return n;
    }
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxRun = 0;
        for (char ch='A'; ch<='Z'; ch++) {
            for (int i=0; i<n; i++) {
                int run = findRun(s.substring(i), k, ch);
                maxRun = Math.max(maxRun, run);
            }
        }
        return maxRun;
    }
}
