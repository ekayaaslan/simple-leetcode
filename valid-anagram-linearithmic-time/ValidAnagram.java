// https://leetcode.com/problems/valid-anagram/
// LC242: Valid Anagram
// Time/space: Linearithmic time, constant extra-space.
// Concepts: Sorting, Canonicalising.
class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        return Arrays.compare(schars, tchars) == 0;
    }
}
