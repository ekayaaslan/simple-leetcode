// https://leetcode.com/problems/two-sum
// LC1: Two Sum
// NC Category: Arrays & Hashing.
// Time/space: Quadratic time, constant extra-space.
// Solution kind: Baseline.
// Approach: Brute force.
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }
}
