// https://leetcode.com/problems/top-k-frequent-elements
// Linearithmic time, linear-ish extra-space.
// Concepts: Hashing, Counting, Sorting, Data-count pairing.
class TopKFrequentElements {
public:
    struct item {
        int num;
        int count;
    };
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> counts;
        for (int num : nums) {
            counts[num] ++;
        }
        vector<item> items;
        for (auto [num, count]: counts) {
            items.push_back({num, count});
        }
        sort(items.begin(), items.end(), [](item lhs, item rhs) {
            return lhs.count > rhs.count;
        });
        vector<int> out;
        for (int i=0; i<k; i++) {
            out.push_back(items[i].num);
        }
        return out;
    }
};