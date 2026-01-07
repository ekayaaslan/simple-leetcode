// https://leetcode.com/problems/coin-change
// LC322. Coin change
// Factorial time, linear extra-space.
// Backtracking, Combinatorial Search.
class CoinChange {
    int search(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) { return -1; }
        int n = coins.length;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            int numCoins = search(coins, amount-coins[i]);
            if (numCoins != -1) {
                min = Math.min(min, numCoins+1);
            }
        }
        if (min == Integer.MAX_VALUE) { 
            return -1; 
        }
        return min;
    } 
    public int coinChange(int[] coins, int amount) {
        int min = search(coins, amount);
        return min < Integer.MAX_VALUE? min: -1;
    }
}
