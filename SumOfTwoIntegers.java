// https://leetcode.com/problems/sum-of-two-integers
// LC371. Sum of Two Integers
// Logarithmic time, logarithmic extra-space.
// Digits, Binary, Addition, 2s complement.
class SumOfTwoIntegers {
    boolean[] twosComplement(boolean[] bits) {
        for (int i=0; i<32;i ++) {
            bits[i] = !bits[i];
        }
        boolean carry = bits[0];
        bits[0] = !bits[0];
        int index = 1;
        while (carry && index < 32) {
            carry = bits[index];
            bits[index] = !bits[index];
            index ++;
        }
        return bits;
    }
    boolean[] toBinary(int a) {
        boolean[] bits = new boolean[32];
        int num = Math.abs(a);
        int index = 0;
        while (num > 0) {
            bits[index] = (num%2 == 1);
            num = num/2;
            index ++;
        }
        return a < 0? twosComplement(bits): bits;
    }
    int toDecimal(boolean[] bits) {
        int num = 0;
        for (int i=31; i>=0; i--) {
            num = num*2 + (bits[i]?1:0);
        }
        return num;
    }
    public int getSum(int a, int b) {
        boolean[] lhs = toBinary(a);
        boolean[] rhs = toBinary(b);
        boolean[] result = new boolean[32];
        boolean carry = false;
        for (int i=0; i<32; i++) {
            if (lhs[i] && rhs[i]) {
                result[i] = carry;
                carry = true;
                continue;
            }
            if (lhs[i] || rhs[i]) {
                result[i] = !carry;
                continue;
            }
            result[i] = carry;
            carry = false;
        }  
        return toDecimal(result);
    }
}
