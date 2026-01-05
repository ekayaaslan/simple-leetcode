// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
// LC153. Find Minimum in Rotated Sorted Array
// Linear time, constant extra-space.
class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}
