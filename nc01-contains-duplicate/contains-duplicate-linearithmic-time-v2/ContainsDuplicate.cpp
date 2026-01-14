// https://leetcode.com/problems/contains-duplicate
// Linearithmic time, linear extra-space.
// Concepts: Balanced trees, Counting.
class ContainsDuplicate {
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
