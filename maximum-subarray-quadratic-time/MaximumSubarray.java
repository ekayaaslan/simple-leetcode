// https://leetcode.com/problems/maximum-subarray
// LC53. Maximum Subarray
// Quadratic time, linear extra-space.
class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        prefix[0] = 0;
        for (int i=1; i<=n; i++) {
            prefix[i] = nums[i-1]+prefix[i-1];
        }
        int largestSum = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int sum = prefix[j+1]-prefix[i];
                largestSum = Math.max(sum, largestSum);
            }
        }
        return largestSum;
    }
}