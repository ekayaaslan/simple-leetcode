// https://leetcode.com/problems/minimum-window-substring
// LC76. Minimum Window Substring
// Cubic time, constant extra-space.
class MinimumWindowSubstring {
    boolean hasAllLetters(String s, int[] targets) {
        int n = s.length();
        int[] counts = new int[128];
        for (int i=0; i<n; i++) {
            int ch = s.charAt(i);
            counts[ch] ++;
        }
        for (int ch=0; ch<128; ch++) {
            if (counts[ch] < targets[ch]) {
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int[] targets = new int[128];
        for (int i=0; i<t.length(); i++) {
            targets[t.charAt(i)]++;
        }
        int n = s.length();
        int min = Integer.MAX_VALUE;
        String minString = new String();
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                if (hasAllLetters(s.substring(i,j+1), targets)) {
                    if (j-i+1 < min) {
                        min = j-i+1;
                        minString = s.substring(i,j+1);
                    }
                }
            }
        }
        return minString;
    }
}
