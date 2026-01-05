// https://leetcode.com/problems/jump-game
// LC55. Jump Game
// Quadratic time, linear extra-space.
class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] isReachable = new boolean[n];
        isReachable[n-1] = true;
        for (int i=n-2; i>=0; i--) {
            if (nums[i] == 0) {
                isReachable[i] = false;
                continue;
            } 
            for (int j=i+1; j<=i+nums[i] && j<n; j++) {
                if (isReachable[j]) {
                    isReachable[i] = true;
                    break;
                }
            }
        }
        return isReachable[0];
    }
}