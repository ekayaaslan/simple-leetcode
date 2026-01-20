// https://leetcode.com/problems/two-sum
// Linearish time, linearish extra-space.
// Concepts: Hashing, Index mapping, Math.
class TwoSum {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        unordered_map<int,int> idx;
        for (int i=0; i<n; i++) {
            int num = nums[i];
            idx[num] = i;
        }
        for (int i=0; i<n; i++) {
            int num = nums[i];
            if (num * 2 == target) {
                if (idx[num] != i) {
                    return {idx[num], i};
                }
                continue;
            }
            int complem = target-num;
            if (idx.contains(complem)) {
                return {idx[complem], i};
            }
        }
        return {};
    }
};