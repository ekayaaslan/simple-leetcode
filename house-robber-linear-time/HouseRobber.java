// https://leetcode.com/problems/house-robber
// LC198. House Robber
// Linear time, linear extra-space.
class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) { return nums[0]; }
        int[] money = new int[n];
        money[n-1] = nums[n-1];
        money[n-2] = Math.max(nums[n-2], nums[n-1]);
        for (int i=n-3; i>=0; i--) {
            money[i] = Math.max(money[i+1], nums[i]+money[i+2]);
        }
        return Math.max(money[0],money[1]);
    }
}
