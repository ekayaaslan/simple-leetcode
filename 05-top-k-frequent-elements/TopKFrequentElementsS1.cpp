// https://leetcode.com/problems/top-k-frequent-elements
// Quadratic time, linear-ish extra-space.
// Concepts: Hashing, Counting, Brute force.
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
        vector<int> out;
        for (int i=0; i<k; i++) {
            int maxnum = 0;
            for (auto [num, count]: counts) {
                if (count > counts[maxnum]) {
                    maxnum = num;
                }
            }
            counts.erase(maxnum);
            out.push_back(maxnum);
        }
        return out;
    }
};