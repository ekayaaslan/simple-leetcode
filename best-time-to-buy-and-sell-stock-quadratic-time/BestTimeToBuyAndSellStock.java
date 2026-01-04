// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-quadratic-time
// LC121. Best Time to Buy and Sell Stock
// Quadratic time, constant extra-space.
class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                int profit = prices[j]-prices[i];
                max = Math.max(max, profit);
            }
        }
        return max;
    }
}
