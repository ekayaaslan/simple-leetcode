// https://leetcode.com/problems/contains-duplicate/
// LC217: Contains Duplicate
// NC Category: Arrays & Hashing.
// Time/space: Quadratic time, constant extra-space.
// Solution kind: Baseline.
// Approach: Brute force.
class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
