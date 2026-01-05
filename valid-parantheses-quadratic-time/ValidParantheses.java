// https://leetcode.com/problems/valid-parentheses
// LC20. Valid Parantheses
// Quadratic time, constant extra-space.
class ValidParantheses {
    boolean isPaired(char a, char b) {
        if (a == '(' && b == ')') { return true; }
        if (a == '{' && b == '}') { return true; }
        if (a == '[' && b == ']') { return true; }
        return false;        
    }
    int findPair(char[] chars, int n) {
        for (int i=0; i<n-1; i++) {
            if (isPaired(chars[i], chars[i+1])) {
                return i;
            }
        }
        return -1;
    }
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n%2 == 1) { return false; }
        int size = n;
        for (int i=0; i<n/2; i++) {
            int p = findPair(chars, size);
            if (p == -1) { return false; }
            for (int j=p; j<size-2; j++) {
                chars[j] = chars[j+2];
            }
            size = size-2;
        }
        return true;
    }
}
