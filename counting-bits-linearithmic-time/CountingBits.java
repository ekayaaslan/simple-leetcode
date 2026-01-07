// https://leetcode.com/problems/counting-bits
// LC338. Counting Bits
// Linearithmic time, constant extra-space.
class CountingBits {
    public int hammingDistance(int n) {
        int num = n;
        int count = 0;
        while (num > 0) {
            if (num%2 == 1) { 
                count++; 
            }
            num = num/2;
        }
        return count;
    }    
    public int[] countBits(int n) {
        int[] ones = new int[n+1];
        for (int i=0; i<=n; i++) {
            ones[i] = hammingDistance(i);
        }
        return ones;
    }
}
