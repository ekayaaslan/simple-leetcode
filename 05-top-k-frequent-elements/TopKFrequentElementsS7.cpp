// https://leetcode.com/problems/top-k-frequent-elements
// Linear time, linear-ish extra-space.
// Concepts: Hashing, Running counts, Bucket sort.
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> counts;
        int n = nums.size();
        vector<vector<int>> buckets(n+1);
        for (int num : nums) {
            int c = ++counts[num];
            buckets[c].push_back(num);
        }
        vector<int> out;
        int i = n;
        while (k > 0) {
            if (buckets[i].empty()) {
                i --;
                continue;
            }
            int num = buckets[i].back();
            buckets[i].pop_back();
            if (counts.contains(num)) {
                counts.erase(num);
                out.push_back(num);
                k --;
            }
        }
        return out;
    }
};