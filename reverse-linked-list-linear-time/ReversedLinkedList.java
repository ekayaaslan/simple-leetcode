// https://leetcode.com/problems/reverse-linked-list
// LC206. Reversed Linked List
// Linear time, linear extra-space.
class ReversedLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) { return null; }
        if (head.next == null) { return head; }
        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }
}
