public class L83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode listNode = head;
        while (listNode.next != null){
            if (listNode.next.val == listNode.val)
                listNode.next = listNode.next.next;
            else listNode = listNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(5);
        System.out.println(l.val);
    }
}
