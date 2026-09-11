/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        for (int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode leftNode = curr;
        ListNode beforeLeft = prev;

        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if(beforeLeft != null) {
            beforeLeft.next = prev;
        } else {
            head = prev;
        }
        leftNode.next = curr;

        return head;
    }
}