// https://leetcode.com/problems/reverse-bits
// LC190. Reverse Bits
// Logarithmic time, constant extra-space.
// Digits, Binary.
class ReverseBits {
    public int reverseBits(int n) {
        int num = n;
        int reverse = 0;
        for (int i=0; i<32; i++) {
            int bit = num%2;
            reverse = reverse*2 + bit;
            num = num/2;
        }
        return reverse;
    }
}
