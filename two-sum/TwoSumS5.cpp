// https://leetcode.com/problems/two-sum
// Linearithmic time, linear extra-space.
// Concepts: Sorting, Two pointers, Data-index pairing.
class TwoSum {
private:
    struct item {
        int num;
        int idx;
    };
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        vector<item> items(n);
        for (int i=0; i<n; i++) { 
            items[i] = {nums[i], i};
        }
        sort(items.begin(), items.end(), [](item lhs, item rhs) {
            return lhs.num < rhs.num;
        });
        int i = 0;
        int j = n-1;
        while (i < j) {
            int sum = items[i].num + items[j].num;
            if (sum == target) {
                return {items[i].idx, items[j].idx};
            }
            if (sum < target) { 
                i ++;
            } else {
                j --;
            }
        }
        return {};
    }
};
