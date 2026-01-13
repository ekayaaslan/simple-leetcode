// https://leetcode.com/problems/two-sum
// Linearlogsquared time, linear extra-space.
// Concept: Divide and conquer, Recursive search, Balanced trees.
class TwoSum {
private:
    vector<int> search(vector<int>& nums, int lo, int mid, int hi, int target) {
        map<int,int> idx;
        for (int i=lo; i<=mid; i++) {
            idx[nums[i]] = i;
        }
        for (int j=mid+1; j<=hi; j++) {
            int complem = target-nums[j];
            if (idx.contains(complem)) {
                return {idx[complem], j};
            }
        }
        return {};
    }
    vector<int> search(vector<int>& nums, int lo, int hi, int target) {
        if (lo == hi) {
            return {};
        }
        int mid = (lo+hi)/2;
        vector<int> left = search(nums, lo, mid, target);
        if (!left.empty()) {
            return left;
        }
        vector<int> right = search(nums, mid+1, hi, target);
        if (!right.empty()) {
            return right;
        }
        return search(nums, lo, mid, hi, target);
    }
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        return search(nums, 0, n-1, target);
    }
};