// https://leetcode.com/problems/top-k-frequent-elements
// Linear-ish time, linear-ish extra-space.
// Concepts: Hashing, Counting, Quickselect, Data-count pairing.
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
        nth_element(items.begin(), items.begin()+k, items.end(), 
            [](item& lhs, item& rhs) {
                return lhs.count > rhs.count;
            }
        );
        vector<int> out;
        for (int i=0; i<k; i++) {
            out.push_back(items[i].num);
        }
        return out;
    }
};