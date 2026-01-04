// https://leetcode.com/problems/longest-substring-without-repeating-characters
// LC3. Longest Substring Without Repeating Characters
// Linear time, constant extra-space.
class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) { return 0; }
        int[] lastSeen = new int[128];
        boolean[] seen = new boolean[128];
        int n = s.length();
        int[] longest = new int[n];
        longest[0] = 1;
        seen[s.charAt(0)] = true;
        lastSeen[s.charAt(0)] = 0;
        int longestOfAll = longest[0];        
        for (int i=1; i<n; i++) {
            char ch = s.charAt(i);
            if (!seen[ch]) {
                longest[i] = longest[i-1]+1;
                seen[ch] = true;
            } else {
                longest[i] = Math.min(longest[i-1]+1, i-lastSeen[ch]);
            }
            lastSeen[ch] = i;
            longestOfAll = Math.max(longestOfAll, longest[i]);            
        }
        return longestOfAll;
    }
}
