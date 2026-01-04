// https://leetcode.com/problems/longest-substring-without-repeating-characters
// LC3. Longest Substring Without Repeating Characters
// Linear time, constant extra-space.
class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) { return 0; }
        int[] lastSeen = new int[128];
        boolean[] seen = new boolean[128];
        int n = s.length();
        int longest = 1;
        seen[s.charAt(0)] = true;
        lastSeen[s.charAt(0)] = 0;
        int longestOfAll = longest;        
        for (int i=1; i<n; i++) {
            char ch = s.charAt(i);
            if (!seen[ch]) {
                longest = longest+1;
                seen[ch] = true;
            } else {
                longest = Math.min(longest+1, i-lastSeen[ch]);
            }
            lastSeen[ch] = i;
            longestOfAll = Math.max(longestOfAll, longest);            
        }
        return longestOfAll;
    }
}
