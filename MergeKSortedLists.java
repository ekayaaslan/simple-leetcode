// https://leetcode.com/problems/merge-k-sorted-lists
// LC23. Mrege K Sorted Lists
// Linearithmic-time, linear extra-space.
class MergeKSortedLists {
    class Item implements Comparable<Item> {
        ListNode node;
        Item(ListNode node) {
            this.node = node;
        }
        @Override
        public int compareTo(Item other) {
            return Integer.compare(node.val, other.node.val);
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Item> pq = new PriorityQueue();
        for (int i=0; i<lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(new Item(lists[i]));
            }
        }
        ListNode res = new ListNode();
        ListNode prev = res;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll().node;
            prev.next = new ListNode(node.val);
            if (node.next != null) {
                pq.offer(new Item(node.next));
            }
            prev = prev.next;
        }
        return res.next;        
    }
}
