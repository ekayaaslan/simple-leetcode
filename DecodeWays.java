// https://leetcode.com/problems/decode-ways
// LC91. Decode Ways.
// Linear time, linear extra-space.
// 1D Dynamic programming, Combinatorics.
class DecodeWays {
    boolean isDigit(char ch) {
        return ch > '0' && ch <= '9';
    }
    boolean isCode(char a, char b) {
        if (!isDigit(a)) { return false; }
        if (b != '0' && !isDigit(b)) { return false; }
        int val = (a-'0')*10 + (b-'0');
        return val <= 26;

    }
    public int numDecodings(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] counts = new int[n+1];
        counts[n] = 1;
        if (isDigit(chars[n-1])) {
            counts[n-1] = 1;
        }
        for (int i=n-2; i>=0; i--) {
            if (isDigit(chars[i])) {
                counts[i] += counts[i+1];
            }
            if (isCode(chars[i], chars[i+1])) {
                counts[i] += counts[i+2];
            }
        }
        return counts[0];
    }
}
