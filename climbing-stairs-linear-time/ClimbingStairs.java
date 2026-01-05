// https://leetcode.com/problems/climbing-stairs
// LC70. Climbing Stairs
// Linear time, linear extra-space.
class ClimbingStairs {
    public int climbStairs(int n) {
        int[] steps = new int[n+1];
        steps[n] = 1;
        steps[n-1] = 1;
        for (int i=n-2; i>=0; i--) {
            steps[i] = steps[i+1] + steps[i+2];
        }
        return steps[0];
    }
}
