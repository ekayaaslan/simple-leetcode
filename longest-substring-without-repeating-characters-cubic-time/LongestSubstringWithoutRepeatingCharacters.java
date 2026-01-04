// https://leetcode.com/problems/longest-substring-without-repeating-characters
// LC3. Longest Substring Without Repeating Characters
// Cubic time, constant extra-space.
// Concepts: Linear Search, Direct addressing.
class LongestSubstringWithoutRepeatingCharacters {
    class Substring {
        int start;
        int end;
        String string;
        Substring(String string, int start, int end) {
            this.string = string;
            this.start = start;
            this.end = end;
        }
        char charAt(int index) {
            return string.charAt(start+index);
        }
        int length() {
            return end-start;
        }
    }
    boolean hasUniqueChars(Substring substring) {
        boolean[] seen = new boolean[128];
        for (int i=0; i<substring.length(); i++) {
            char ch = substring.charAt(i);
            if (seen[ch]) { return false; }
            seen[ch] = true;
        }
        return true;
    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int longest = 0;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                if (hasUniqueChars(new Substring(s, i, j+1))) {
                    longest = Math.max(longest, j-i+1);
                }
            }
        }
        return longest;
    }
}
