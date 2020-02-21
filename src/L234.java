public class L234 {
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode head2 = reverseCopy(head);
        while (head != null){
            if (head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    public static ListNode reverseCopy(ListNode head){
        ListNode prev = null, curr = head;
        while (curr != null){
            ListNode tempHead = curr.next;
            ListNode copy = new ListNode(curr.val);
            copy.next = prev;
            prev = copy;
            curr = curr.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(1);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(a));

    }
}
