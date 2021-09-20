import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode234 {
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

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode prepre = null, pre = slow;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
