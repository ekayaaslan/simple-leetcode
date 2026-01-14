// https://leetcode.com/problems/two-sum
// Linearithmic time, linear extra-space.
// Concept: Sorting, Binary search, Symmetry, Data-index pairing.
class TwoSum {
private:
    struct item {
        int num;
        int idx;
    };
    int search(vector<item>& items, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = (lo+hi)/2;
            int num = items[mid].num;
            if (target <= num) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        int num = items[lo].num;
        return (num == target)? lo: -1;
    }
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
        for (int i=0; i<n-1; i++) {
            int num = items[i].num;
            int j = search(items, i+1, n-1, target-num);
            if (j != -1) {
                return {items[i].idx, items[j].idx};
            }
        }
        return {};
    }
};
