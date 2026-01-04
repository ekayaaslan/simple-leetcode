// https://leetcode.com/problems/two-sum
// LC1. Two Sum
// Linear-ish time, linear-ish extra-space.
public TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            numbers.put(nums[i], i);
        }
        for (int i=0; i<n; i++) {
            if (nums[i]*2 == target) { continue; }
            int complement = target-nums[i];
            if (numbers.containsKey(complement)) {
                return new int[] {i, numbers.get(complement)};
            }
        }
        if (target % 2 == 0) {
            int foundIndex = -1;
            for (int i=0; i<n; i++) {
                if (nums[i] != target/2) { continue; }
                if (foundIndex != -1) {
                    return new int[] {foundIndex, i};
                }
                foundIndex = i;                    
            }
        }
        return new int[] {};
    }
}
