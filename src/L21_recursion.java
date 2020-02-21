public class L21_recursion {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode H = new ListNode(-1);
        ListNode head = new ListNode(-1);
        H.next = head;
        merge(head, l1, l2);
        return H.next.next;
    }

    public ListNode merge(ListNode head, ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) {
            head.next = l2;
            return head;
        }
        if (l2 == null) {
            head.next = l1;
            return head;
        }
        if (l1.val > l2.val) {
            head.next = l2;
            l2 = l2.next;
        }
        if (l1.val <= l2.val){
            head.next = l1;
            l1 = l1.next;
        }
        head = head.next;
        return head;
    }
}
