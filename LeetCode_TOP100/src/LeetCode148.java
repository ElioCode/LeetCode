public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode h1 = head;
        ListNode middle = findMiddle(head);
        ListNode h2 = middle.next;
        middle.next = null;

        ListNode res = merge(h1, h2);
        return res;

    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode head = new ListNode();
        ListNode res = head;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                head.next = h1;
                h1 = h1.next;
            }else{
                head.next = h2;
                h2 = h2.next;
            }
            head = head.next;
        }
        head.next = h1 == null ? h2 : h1;
        return res.next;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
