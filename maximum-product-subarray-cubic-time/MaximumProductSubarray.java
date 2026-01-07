// https://leetcode.com/problems/maximum-product-subarray
// LC152. Maximum Product Subarray
// Cubic time, constant extra-space.
// Brute force.
class MaximumProductSubarray {
    int getProduct(int[] nums, int start, int end) {
        int product = 1;
        for (int i=start; i<end; i++) {
            product *= nums[i];
        }
        return product;
    }
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                maxProduct = Math.max(maxProduct, getProduct(nums, i, j+1));
            }
        }
        return maxProduct;
    }
}
