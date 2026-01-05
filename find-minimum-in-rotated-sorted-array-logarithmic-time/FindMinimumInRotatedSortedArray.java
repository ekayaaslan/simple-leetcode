// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
// LC153. Find Minimum in Rotated Sorted Array
// Logarithmic time, constant extra-space.
class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) { return nums[0]; }
        int lo = 0;
        int hi = n-1;
        while (lo < hi-1) {
            if (nums[lo] < nums[hi]) {
                return nums[lo];
            }
            int mid = (lo+hi)/2;
            if (nums[lo] < nums[mid]) {
                lo = mid+1;
            } else { hi = mid; }
        }
        return Math.min(nums[lo], nums[hi]);
    }
}
