// https://leetcode.com/problems/merge-two-sorted-lists
// LC21. Merge Two Sorted Lists
// Linear time, constant extra-space.
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode lhs = list1;
        ListNode rhs = list2;
        ListNode res = new ListNode();
        ListNode prev = res;
        while (lhs != null && rhs != null) {
            if (lhs.val < rhs.val) {
                prev.next = new ListNode(lhs.val);
                lhs = lhs.next;
            } else {
                prev.next = new ListNode(rhs.val);
                rhs = rhs.next;
            }
            prev = prev.next;
        }
        prev.next = (lhs != null)? lhs: rhs;
        return res.next;
    }
}
