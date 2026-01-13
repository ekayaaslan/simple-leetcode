// https://leetcode.com/problems/contains-duplicate
// Linearish time, linearish extra-space.
// Concepts: Hashing, Symmetry.
class ContainsDuplicate {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> numset;
        for (int num : nums) {
            if (numset.contains(num)) {
                return true;
            }
            numset.insert(num);
        }
        return false;
    }
};
