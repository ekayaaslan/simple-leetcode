// https://leetcode.com/problems/contains-duplicate
// LC217. Contains Duplicate
// Quadratic time, constant extra-space.
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
