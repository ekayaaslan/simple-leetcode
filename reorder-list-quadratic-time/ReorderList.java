// https://leetcode.com/problems/reorder-list
// LC143. Reorder List
// Quadratic time, linear extra-space.
class ReorderList {
    public ListNode reverseList(ListNode head) {
        if (head == null) { return null; }
        if (head.next == null) { return head; }
        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }    
    public void reorderList(ListNode head) {
        if (head == null) { return; }
        head.next = reverseList(head.next);
        reorderList(head.next);
    }
}
