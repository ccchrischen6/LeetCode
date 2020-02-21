public class L206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
