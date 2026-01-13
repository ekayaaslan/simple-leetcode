// https://leetcode.com/problems/contains-duplicate
// Linearithmic time, linearithmic extra-space.
// Concepts: Balanced trees, Counting.
class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        map<int,int> counts;
        for (int num : nums) {
            counts[num] ++;
        }
        for (auto [_, count] : counts) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
};
