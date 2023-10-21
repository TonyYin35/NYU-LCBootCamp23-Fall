/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode pointerA = head, pointerB = head;
        while (pointerB != null && pointerB.next != null) {
            pointerA = pointerA.next;
            pointerB = pointerB.next.next;

            if (pointerB == pointerA) {
                return true;
            }
        }
        return false;
    }
}