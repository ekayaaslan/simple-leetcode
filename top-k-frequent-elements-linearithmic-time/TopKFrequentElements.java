// https://leetcode.com/problems/top-k-frequent-elements
// LC347. Top K Frequent Elements
// Linearithmic time, linear extra-space.
class TopKFrequentElements {
    class Item implements Comparable<Item> {
        int num;
        int count;
        Item(int num, int count) {
            this.num = num;
            this.count = count;
        }
        @Override
        public int compareTo(Item other) {
            return Integer.compare(this.count, other.count);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 1;
        int num = nums[0];
        Queue<Item> pq = new PriorityQueue(Collections.reverseOrder());
        for (int i=1; i<n; i++) {
            if (nums[i] != num) {
                pq.offer(new Item(num, count));
                num = nums[i];
                count = 1;
                continue;
            }
            count ++;
        }
        pq.offer(new Item(num, count));
        int[] ans = new int[k];
        for (int i=0; i<k; i++) {
            ans[i] = pq.poll().num;
        }
        return ans;
    }
}
