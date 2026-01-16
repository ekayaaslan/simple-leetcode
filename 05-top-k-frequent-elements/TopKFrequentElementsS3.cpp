// https://leetcode.com/problems/top-k-frequent-elements
// Linearithmic time, linear-ish extra-space.
// Concepts: Hashing, Counting, Priority queues, Data-count pairing, TopK.
class TopKFrequentElements {
public:
    struct item {
        int num;
        int count;
        bool operator>(item other) const {
            return count > other.count;
        }
    };
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> counts;
        for (int num : nums) {
            counts[num] ++;
        }
        priority_queue<item, vector<item>, greater<item>> pq;
        for (auto [num, count]: counts) {
            item cur = {num, count};
            if (pq.size() < k) {
                pq.push(cur);
                continue;
            }
            if (cur > pq.top()) {
                pq.pop();
                pq.push(cur);
            }
        }
        vector<int> out;
        while (!pq.empty()) {
            out.push_back(pq.top().num);
            pq.pop();
        }
        return out;
    }
};