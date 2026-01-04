// https://leetcode.com/problems/two-sum
// LC1: Two Sum
// Time/space: Linearithmic time, linear extra-space.
// Concepts: Binary Search.
class TwoSum {
    int find(Item[] items, int start, int target) {
        int lo = start;
        int hi = items.length-1;
        while(lo < hi) {
            int mid = (lo+hi)/2;
            if (target <= items[mid].num) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return items[lo].num == target? lo: -1;
    }
    class Item implements Comparable<Item> {
        int id;        
        int num;
        Item(int id, int num) {
            this.id = id;
            this.num = num;
        }
        @Override
        public int compareTo(Item other) {
            return Integer.compare(this.num, other.num);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Item[] items = new Item[n];
        for (int i=0; i<n; i++) {
            items[i] = new Item(i, nums[i]);
        }
        Arrays.sort(items);
        for (int i=0; i<n-1; i++) {
            int complement = target-items[i].num;
            int j = find(items, i+1, complement); 
            if (j != -1) {
                return new int[] {items[i].id, items[j].id};
            }
        }
        return new int[] {};
    }
}
