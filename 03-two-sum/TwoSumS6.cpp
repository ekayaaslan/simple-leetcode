// https://leetcode.com/problems/two-sum
// Linearithmicish time, linearish extra-space.
// Concept: Divide and conquer, Recursive search, Hashing, Index mapping.
class TwoSum {
private:
    vector<int> search(vector<int>& nums, int lo, int mid, int hi, int target) {
        map<int,int> idxmap;
        for (int i=lo; i<=mid; i++) {
            idxmap[nums[i]] = i;
        }
        for (int j=mid+1; j<=hi; j++) {
            int complem = target-nums[j];
            if (idxmap.contains(complem)) {
                return {idxmap[complem], j};
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