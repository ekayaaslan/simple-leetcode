// https://leetcode.com/problems/search-in-rotated-sorted-array
// LC33. Search in Rotated Sorted Array
// Linear time, constant extra-space.
class SearchInRotatedSortedArray{
    public int search(int[] nums, int target) {
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
