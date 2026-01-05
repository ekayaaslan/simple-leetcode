// https://leetcode.com/problems/longest-palindromic-substring
// LC5. Longest Palindromic Substring
// Cubic time, constant extra-space.
class LongestPalindromicSubstring {
    boolean isPalindrom(String s) {
        int n = s.length();
        for (int i=0; i<n; i++) {
            if (s.charAt(i) != s.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }
    String updateLongestIfPalindrom(String s, String longest) {
        return s.length() > longest.length() && isPalindrom(s)? s: longest;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        String longest = "";
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<=n; j++) {
                longest = updateLongestIfPalindrom(s.substring(i,j), longest);
            }
        }
        return longest;
    }
}