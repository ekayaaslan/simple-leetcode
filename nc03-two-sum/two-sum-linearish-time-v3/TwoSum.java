// https://leetcode.com/problems/two-sum
// LC1. Two Sum
// Linear-ish time, linear-ish extra-space.
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsSoFar = new HashMap();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int complement = target-nums[i];
            if (numsSoFar.containsKey(complement)) {
                return new int[] {numsSoFar.get(complement), i};
            }
            numsSoFar.put(nums[i], i);
        }
        return new int[] {};
    }
}
