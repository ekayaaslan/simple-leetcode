// https://leetcode.com/problems/contains-duplicate/
// Linearish time, linearish extra-space.
// Concepts: Hashing, Counting.
class ContainsDuplicate {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_map<int,int> counts;
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
