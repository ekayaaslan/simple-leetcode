// https://leetcode.com/problems/linked-list-cycle
// LC141. Linked List Cycle
// Linearish time, linearish extra-space.
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode current = head;
        Set<ListNode> nodesSeen = new HashSet<ListNode>();
        while(current != null) {
            if (nodesSeen.contains(current)) {
                return true;
            }
            nodesSeen.add(current);
            current = current.next; 
        }
        return false;
    }
}
