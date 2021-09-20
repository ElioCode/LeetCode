public class LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode res = temp;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return res.next;
    }
}
