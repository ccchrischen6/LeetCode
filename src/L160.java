public class L160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        while (headA != headB){
            if (headA == null)
                headA = dummyB;
            else headA = headA.next;
            if (headB == null)
                headB = dummyA;
            else headB = headB.next;
        }
        return headA;
    }
    //if they do not have an interception, they will meet at null, and return null

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(5);
        a.next.next.next = new ListNode(8);
        a.next.next.next.next = new ListNode(7);

        ListNode b = new ListNode(10);
        b.next = new ListNode(5);


        System.out.println(getIntersectionNode(a,b));
    }
}
