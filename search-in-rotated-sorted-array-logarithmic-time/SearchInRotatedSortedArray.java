// https://leetcode.com/problems/search-in-rotated-sorted-array
// LC33. Search in Rotated Sorted Array
// Logarithmic time, constant extra-space.
class SearchInRotatedSortedArray {
    int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) { return 0; }
        int lo = 0;
        int hi = n-1;
        while (lo < hi-1) {
            if (nums[lo] < nums[hi]) {
                return lo;
            }
            int mid = (lo+hi)/2;
            if (nums[lo] < nums[mid]) {
                lo = mid+1;
            } else { hi = mid; }
        }
        return nums[lo] < nums[hi]? lo: hi;
    }    
    public int search(int[] nums, int target) {
        int n = nums.length;        
        int lo = findMin(nums);
        if (target < nums[lo]) {
            return -1;
        }
        int hi = lo>0? lo-1: n-1;
        if (target < nums[0]) {
            hi = n-1;
        } else { lo = 0; }
        while (lo < hi) {
            int mid = (lo+hi)/2;
            if (target > nums[mid]) {
                lo = mid+1;
            } else { hi = mid; }
        }
        return nums[lo] == target? lo: -1;
    }
}
}
