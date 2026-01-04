// https://leetcode.com/problems/longest-consecutive-sequence
// LC128. Longest Consecutive Sequence
// Time/space: Cubic time, constant extra-space.
// Solution kind: Baseline.
// Approach: Brute force
class LongestConsecutiveSequence {
    boolean exists(int target, int[] nums) {
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        for (int i=0; i<n; i++) {
            int num = nums[i];
            int target = num+1;
            while (exists(target, nums)) {
                target ++;
            }
            maxLength = Math.max(maxLength, target-num);
        }
        return maxLength;
    }
}
