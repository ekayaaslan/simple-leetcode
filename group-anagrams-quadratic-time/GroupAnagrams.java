// https://leetcode.com/problems/group-anagrams
// LC49. Group Anagrams
// Time/space: Quadratic time, linear extra-space.
// Concepts: Linear Search, Sorting, Cannonicalising.
class GroupAnagrams {
    boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        return Arrays.compare(schars, tchars) == 0;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new ArrayList();
        int n = strs.length;
        boolean[] used = new boolean[n];
        for (int i=0; i<n; i++) {
            if (used[i]) { continue; }
            List<String> anagrams = new ArrayList();
            anagrams.add(strs[i]);
            for (int j=i+1; j<n; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    anagrams.add(strs[j]);
                    used[j] = true;
                }
            }
            out.add(anagrams);
        }
        return out;
    }
}