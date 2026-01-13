// https://leetcode.com/problems/contains-duplicate
// Linearithmic time, linearithmic extra-space.
// Concepts: Balanced trees, Symmetry.
class ContainsDuplicate {
public:
    bool containsDuplicate(vector<int>& nums) {
        std::set<int> set;
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.insert(num);
        }
        return false;
    }
};
