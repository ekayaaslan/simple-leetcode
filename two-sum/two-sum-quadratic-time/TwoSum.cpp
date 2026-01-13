// https://leetcode.com/problems/two-sum
// Quadratic time, constant extra-space.
// Concept: Brute force.
class TwoSum {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int sum = nums[i]+nums[j];
                if (sum == target) {
                    return {i, j};
                }
            }
        }
        return {};
    }
};