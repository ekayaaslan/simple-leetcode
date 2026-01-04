class ValidPalindrom {
    boolean isAlphanumeric(char ch) {
        if (ch >= 'a' && ch <= 'z') { return true; }
        if (ch >= '0' && ch <= '9') { return true; }
        return false;
    }
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int n = chars.length;
        int size = 0;
        for (int i=0; i<n; i++) {
            if (isAlphanumeric(chars[i])) {
                chars[size ++] = chars[i];
            }
        }
        for (int i=0; i<size/2; i++) {
            if (chars[i] != chars[size-i-1]) {
                return false;
            }
        }
        return true;
    }
}
