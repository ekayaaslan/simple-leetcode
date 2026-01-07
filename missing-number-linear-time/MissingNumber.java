// https://leetcode.com/problems/missing-number
// LC268. Missing Number
// Linear time, linear extra-space.
class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n+1];
        for (int i=0; i<n; i++) {
            seen[nums[i]] = true;
        }
        for (int i=0; i<=n; i++) {
            if (!seen[i]) {
                return i;
            }
        }
        return 0;
    }
}
