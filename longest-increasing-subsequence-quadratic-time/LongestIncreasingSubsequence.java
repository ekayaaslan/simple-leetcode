// https://leetcode.com/problems/longest-increasing-subsequence
// LC300. Longest Increasing Subsequence
// Quadratic time, linear extra-space.
class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] longest = new int[n];
        int longestSoFar = 0;
        for (int i=n-1; i>=0; i--) {
            longest[i] = 1;
            for (int j=i+1; j<n; j++) {
                if (nums[j] > nums[i]) {
                    longest[i] = Math.max(longest[i], longest[j]+1);
                }
            }
            longestSoFar = Math.max(longestSoFar, longest[i]);
        }
        return longestSoFar;
    }
}
