// https://leetcode.com/problems/top-k-frequent-elements
// Linear time, linear-ish extra-space.
// Concepts: Hashing, Counting, Bucket sort.
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> counts;
        for (int num : nums) {
            counts[num] ++;
        }
        int n = nums.size();
        vector<vector<int>> buckets(n+1);
        for (auto& [num, count] : counts) {
            buckets[count].push_back(num);
        }
        vector<int> out;
        int i = n;
        while (k > 0) {
            if (buckets[i].empty()) {
                i --;
                continue;
            }
            out.push_back(buckets[i].back());
            buckets[i].pop_back();
            k --;
        }
        return out;
    }
};