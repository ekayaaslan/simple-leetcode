// https://leetcode.com/problems/palindromic-substrings
// LC647. Palindromic Substring
// Cubic time, constant extra-space.
// Brute force, Reduction.
class PalindromicSubstring {
    boolean isPalindrom(String s) {
        int n = s.length();
        for (int i=0; i<n/2; i++) {
            if (s.charAt(i) != s.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                if (isPalindrom(s.substring(i,j+1))) {
                    count ++;
                }
            }
        }
        return count;
    }
}
