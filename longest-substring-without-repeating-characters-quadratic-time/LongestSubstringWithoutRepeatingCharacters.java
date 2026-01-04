// https://leetcode.com/problems/longest-substring-without-repeating-characters
// LC3. Longest Substring Without Repeating Characters
// Quadratic time, constant extra-space.
// Concepts: Linear Search, Direct addressing.
class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        boolean[] seen = new boolean[128];
        int longest = 0;
        for (int i=0; i<n; i++) {
            for (int d=0; d<128; d++) { seen[d] = false; }
            for (int j=i; j<n; j++) {
                char ch = s.charAt(j);
                if (seen[ch]) { break; }
                seen[ch] = true;
                longest = Math.max(longest, j-i+1);
            }
        }
        return longest;
    }
}
