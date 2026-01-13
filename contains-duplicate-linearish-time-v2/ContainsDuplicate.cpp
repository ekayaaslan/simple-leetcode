// https://leetcode.com/problems/contains-duplicate
// Linearish time, linearish extra-space.
// Concepts: Hashing, Symmetry.
class ContainsDuplicate {
public:
    bool containsDuplicate(vector<int>& nums) {
        std::unordered_set<int> set;
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.insert(num);
        }
        return false;
    }
};
