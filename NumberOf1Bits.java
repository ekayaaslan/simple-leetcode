// https://leetcode.com/problems/number-of-1-bits
// LC191. Number of 1 Bits
// Logarithmic time, constant extra-space.
// Digits, Binary numbers.
class NumberOf1Bits {
    public int hammingWeight(int n) {
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
}
