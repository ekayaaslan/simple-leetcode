// https://leetcode.com/problems/top-k-frequent-elements
// Linearithmic time, linear-ish extra-space.
// Concepts: Hashing, Running counts, Balance trees, Multiset, Data-count pairing.
class TopKFrequentElements {
public:
    struct item {
        int num;
        int count;
        bool operator<(item other) const {
            if (count != other.count) {
                return count < other.count;
            }
            return num < other.num;
        }
    };
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> counts;
        set<item> numset;
        for (int num : nums) {
            numset.erase({num, counts[num]});
            numset.insert({num, ++counts[num]});
        }
        vector<int> out;
        auto it = numset.rbegin();
        for (int i=0; i<k; i++) {
            out.push_back(it->num);
            it ++;
        }
        return out;
    }
};