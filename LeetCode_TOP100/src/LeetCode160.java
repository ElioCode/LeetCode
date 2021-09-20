public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (headA != headB) {
            headA = headA == null ? B : headA.next;
            headB = headB == null ? A : headB.next;
        }
        return headA;
    }
}
