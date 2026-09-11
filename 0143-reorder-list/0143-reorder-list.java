class Solution {
    ListNode front;

    public void reorderList(ListNode head) {
        front = head;
        reorder(head);
    }

    private boolean reorder(ListNode back) {
        if (back == null) {
            return false;
        }

        if (reorder(back.next)) {
            return true;
        }

        if (front == back || front.next == back) {
            back.next = null;
            return true;
        }

        ListNode next = front.next;

        front.next = back;
        back.next = next;

        front = next;

        return false;
    }
}