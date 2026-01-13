// https://leetcode.com/problems/contains-duplicate
// Quadratic time, constant extra-space.
// Concepts: Brute force, symmetry.
class ContainsDuplicate {
public:
    bool containsDuplicate(vector<int>& nums) {
        int n = nums.size();
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
};
