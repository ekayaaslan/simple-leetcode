// https://leetcode.com/problems/house-robber-ii
// LC213. House Robber II
// Linear time, linear extra-space.
class HouseRobberII {
    int robExceptFirst(int[] nums) {
        int n = nums.length;        
        int[] money = new int[n];
        money[n-1] = nums[n-1];
        money[n-2] = Math.max(nums[n-1], nums[n-2]);
        for (int i=n-3; i>0; i--) {
            money[i] = Math.max(money[i+1], nums[i]+money[i+2]);
        }    
        return money[1];    
    }
    int robExceptLast(int[] nums) {
        int n = nums.length;        
        int[] money = new int[n];
        money[n-2] = nums[n-2];
        money[n-3] = Math.max(nums[n-2], nums[n-3]);
        for (int i=n-4; i>=0; i--) {
            money[i] = Math.max(money[i+1], nums[i]+money[i+2]);
        }    
        return money[0];    
    }    
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) { return nums[0]; }
        if (n == 2) { return Math.max(nums[0], nums[1]); }
        return Math.max(robExceptFirst(nums), robExceptLast(nums));
    }
}
