// https://leetcode.com/problems/contains-duplicate
// Linearithmic time, linearithmic extra-space.
// Concepts: Balanced trees, Symmetry.
class ContainsDuplicate {
public:
    bool containsDuplicate(vector<int>& nums) {
        set<int> numset;
        for (int num : nums) {
            if (numset.contains(num)) {
                return true;
            }
            numset.insert(num);
        }
        return false;
    }
};
