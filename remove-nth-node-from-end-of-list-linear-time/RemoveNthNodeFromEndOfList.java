// https://leetcode.com/problems/remove-nth-node-from-end-of-list
// LC19. Remove Nth Node From End of List
// Linear time, constant extra-space.
class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            size ++;
        }
        if (size == n) {
            return head.next;
        }
        int k = size-n+1;
        node = head;
        for (int i=0; i<k-2; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }
}
