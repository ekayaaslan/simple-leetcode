// https://leetcode.com/problems/two-sum
// LC1. Two Sum
// Linear time, linear extra-space.
// Concepts: Two Pointers.
class TwoSum {
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
        int i = 0;
        int j = n-1;
        while (i < j) {
            int sum = items[i].num + items[j].num;
            if (sum == target) {
                return new int[] {items[i].id, items[j].id};
            }
            if (sum > target) {
                j --;
            } else {
                i ++;
            }
        }
        return new int[] {};
    }
}
