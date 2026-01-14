// https://leetcode.com/problems/contains-duplicate
// Linearlogsquared time, linear extra-space.
// Concepts: Divide and conquer, Recursive search, Balanced trees
class ContainsDuplicate {
private:
    bool search(vector<int>& nums, int lo, int mid, int hi) {
        set<int> numset;
        for (int i=lo; i<=mid; i++) {
            numset.insert(nums[i]);
        }
        for (int i=mid+1; i<=hi; i++) {
            if (numset.contains(nums[i])) {
                return true;
            }
        }
        return false;        
    }
    bool search(vector<int>& nums, int lo, int hi) {
        if (lo == hi) {
            return false;
        }
        int mid = (lo+hi)/2;
        if (search(nums, lo, mid)) {
            return true;
        }
        if (search(nums, mid+1, hi)) {
            return true;
        }
        return search(nums, lo, mid, hi);
    }
public:
    bool containsDuplicate(vector<int>& nums) {
        int n = nums.size();
        return search(nums, 0, n-1);
    }
};
