// https://leetcode.com/problems/two-sum
// Linearish time, linearish extra-space.
// Concepts: Hashing, Counting, Index mapping.
class TwoSum {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        unordered_map<int,vector<int>> idxmap;
        for (int i=0; i<n; i++) {
            int num = nums[i];
            idxmap[num].push_back(i);
        }
        for (auto [num, idx] : idxmap) {
            if (num * 2 == target) {
                if (idx.size() > 1) {
                    return {idx[0], idx[1]};
                }
                continue;
            }
            int complem = target-num;
            if (idxmap.contains(complem)) {
                return {idx[0], idxmap[complem][0]};
            }
        }
        return {};
    }
};